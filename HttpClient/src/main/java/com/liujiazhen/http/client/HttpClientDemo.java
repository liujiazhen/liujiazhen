package com.liujiazhen.http.client;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.shanshoufu.api.util.PackageUtil;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

public class HttpClientDemo {
    /**
     * Demo用到的HTTP调用工具maven坐标：
     *         <dependency>
     *             <groupId>org.apache.httpcomponents</groupId>
     *             <artifactId>httpclient</artifactId>
     *             <version>4.5.10</version>
     *         </dependency>
     */
    public static void main(String[] args) throws Exception {
        // 平台公钥路径
        String ssfPukPath = "F:/key/public-rsa.cer";
        // 调用方私钥路径
        String userCertPath = "F:/key/liuhe-rsa.pfx";

        // 1.构造请求参数 JSON格式
        String pkgJson = "{\"reqPkgHead\":{\"bsnCode\":\"3101\",\"busiOrg\":\"ssf\",\"appNo\":\"0001\",\"reqTime\":\"20200101\",\"userName\":\"aaaaa\",\"version\":\"1.0.0\",\"serialNo\":\"9999999\"},\"pkgBody\":{\"dueDate\":\"20200601\",\"remark\":\"remark\",\"isseDate\":\"20200601\"}}";
        // 2.参数签名并加密
        // (1)要加密的Json (2)调用方私钥证书 (3)私钥密码 (4)平台方公钥
        String encryptWithSign = PackageUtil.encryptAndSign(pkgJson, userCertPath, "123456", ssfPukPath);

        // 构建请求参数结构
        String paramJson = "{\"appNo\":\"0001\",\"context\":\"" + encryptWithSign + "\"}";

        // 3.调用接口
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        // 创建POST请求
        HttpPost httpPost = new HttpPost("http://127.0.0.1:8082/server-connector/recvGateway/service");
        httpPost.addHeader("Content-Type", "application/json");
        StringEntity stringEntity = new StringEntity(paramJson, "utf-8");
        httpPost.setEntity(stringEntity);
        CloseableHttpResponse response = httpClient.execute(httpPost);
        HttpEntity entity = response.getEntity();

        String resultString = entityUtil(entity);

        // 4.解密返回值
        // (1)密文 (2)私钥路径 (3)私钥密码
        String resultJson = PackageUtil.decrypt(resultString, userCertPath, "123456");
        System.out.println(resultJson);

        // 5.验证签名
        JSONObject resultJsonObject = JSON.parseObject(resultJson, Feature.OrderedField);
        String sign = resultJsonObject.getString("sign");
        String pkg = resultJsonObject.getString("pkg");
        // (1)签名值 (2)原文 (3)平台方公钥
        boolean b = PackageUtil.verifySign(sign, pkg, ssfPukPath);
        System.out.println(b);

    }

    private static String entityUtil(HttpEntity entity) throws IOException {
        final InputStream inStream = entity.getContent();
        if (inStream == null) {
            return null;
        }
        try {
            Args.check(entity.getContentLength() <= Integer.MAX_VALUE, "HTTP entity too large to be buffered in memory");
            int capacity = (int) entity.getContentLength();
            if (capacity < 0) {
                capacity = 8192;
            }

            final Reader reader = new InputStreamReader(inStream, StandardCharsets.UTF_8);
            final CharArrayBuffer buffer = new CharArrayBuffer(capacity);
            final char[] tmp = new char[1024];
            int l;
            while ((l = reader.read(tmp)) != -1) {
                buffer.append(tmp, 0, l);
            }
            return buffer.toString();
        } finally {
            inStream.close();
        }
    }
/*
请求参数Json结构
{
    "sign": "MEUCIFt4VbuA1CXGfA5W5ybmWYpxkpGPmKPhImRM7Sl3/Wi4AiEAqmqr1xvmLah9vaHuYZ4k2wzHehVBCQ1el/+X9n14i1E=",
    "pkg": {
        "reqPkgHead": {
            "version": "1.0.0",
            "appNo": "0001",
            "reqTime": "20200612103388",
            "serialNo": "2020061200000001",
            "bsnCode": "000000",
            "userName": "liujiazhen",
            "busiOrg": "alibaba"
        },
        "pkgBody": {
            "clientType": "0",
            "clientName": "测试",
            "idType": "1",
            "idCode": "110000012311112311",
            "mobile": "13600088811",
            "email": "xuxu@sohu.com"
        }
    }
}
 */

/*
应答Json结构
{
    "sign": "MEUCIFt4VbuA1CXGfA5W5ybmWYpxkpGPmKPhImRM7Sl3/Wi4AiEAqmqr1xvmLah9vaHuYZ4k2wzHehVBCQ1el/+X9n14i1E=",
    "pkg": {
        "resPkgHead": {
            "version": "1.0.0",
            "appNo": "0001",
            "resTime": "20200612103388",
            "serialNo": "2020061200000001",
            "retCode": "000000",
            "retMsg": "操作完成！"
        },
        "pkgBody": {
            "clientType": "0",
            "clientName": "测试",
            "idType": "1",
            "idCode": "110000012311112311",
            "mobile": "13600088811",
            "email": "xuxu@sohu.com"
        }
    }
}
 */
}
