package com.liujiazhen.http.client;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.liujiazhen.http.param.*;
import com.liujiazhen.util.RandomUtils;
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

public class Param {
    private static boolean REMOTE;
    public static void main(String[] args) throws Exception {
        REMOTE = false; // true为测试远程
        String serialNo = RandomUtils.getRandomNumString(32);
        System.out.println("serialNo:" + serialNo);

//        test3101(serialNo); // 出票申请
//        test3102(serialNo); // 承兑申请
//        test3103(serialNo); // 提示收票
//        test3001(serialNo); // 背书申请 DRAFT_ENDORSEMENT
//        test3002(serialNo); // 贴现申请
//        test1201(serialNo); // 业务撤销
//        test3104(serialNo); // 撤票申请
//        test3106(serialNo); // 保证申请
//        test3107(serialNo); // 质押申请
//        test7075(serialNo, "14110225332656689259290989070194"); // 异步查询结果
        test7076(serialNo); // 保证信息查询
//        test7071(serialNo); // 票据基本信息查询
//        test7072(serialNo); // 票据正面信息查询
//        test7073(serialNo); // 票据背面信息查询
//        test8001(serialNo); // 额度查询

//        test3201(serialNo); // 收票签收
//        test3204(serialNo); // 承兑签收
//        test3206(serialNo); // 保证签收
//        test3202(serialNo); // 背书签收

    }

    public static String get7075Param(String serialNo, String bsuiNo) {
        JSONObject jsonObject = new JSONObject();
        JSONObject reqPkgHead = new JSONObject();
        JSONObject pkgBody = new JSONObject();

        reqPkgHead.put("version", "1.0.0");
        reqPkgHead.put("appNo", "LiuHe000001");
        reqPkgHead.put("reqTime", "20200715");
        reqPkgHead.put("serialNo", serialNo);
        reqPkgHead.put("bsnCode", "7075");
        reqPkgHead.put("userName", "Liu Zen");
        reqPkgHead.put("busiOrg", "ssf1");

        pkgBody.put("bizKind", "AC02");
        pkgBody.put("transNo", bsuiNo);
        pkgBody.put("msgType", "this is msgType");
        pkgBody.put("txTransdate", "20200715");

        jsonObject.put("reqPkgHead", reqPkgHead);
        jsonObject.put("pkgBody", pkgBody);

        return jsonObject.toJSONString();
    }

    public static void test3201(String serial) throws Exception {
        String param = Tx3201Param.getParam(serial);
        System.out.println("调用3201参数：\n" + param);
        call(param);
    }
    public static void test3204(String serial) throws Exception {
        String param = Tx3204Param.getParam(serial);
        System.out.println("调用3204参数：\n" + param);
        call(param);
    }
    public static void test3202(String serial) throws Exception {
        String param = Tx3202Param.getParam(serial);
        System.out.println("调用3202参数：\n" + param);
        call(param);
    }
    public static void test7073(String serial) throws Exception {
        String param = Tx7073Param.getParam(serial);
        System.out.println("调用7073参数：\n" + param);
        call(param);
    }
    public static void test3206(String serial) throws Exception {
        String param = Tx3206Param.getParam(serial);
        System.out.println("调用3206参数：\n" + param);
        call(param);
    }
    public static void test3102(String serial) throws Exception {
        String param = Tx3102Param.getParam(serial);
        System.out.println("调用3102参数：\n" + param);
        call(param);
    }

    public static void test7076(String serial) throws Exception {
        String param = Tx7076Param.getParam(serial);
        System.out.println("调用7076参数：\n" + param);
        call(param);
    }

    public static void test7075(String serial, String busino) throws Exception {
        String param = get7075Param(serial, busino);
        System.out.println("调用接口7075参数:\n" + param);
        call(param);
    }

    public static void test3101(String serial) throws Exception {
        String call3101Param = Tx3101Param.getParam(serial);
        System.out.println("调用接口3103参数:\n" + call3101Param);
        call(call3101Param);
    }

    public static void test7071(String serial) throws Exception {
        String param = Tx7071Param.getParam(serial);
        System.out.println("调用接口7071参数:\n" + param);
        call(param);
    }

    public static void test7072(String serial) throws Exception {
        String param = Tx7072Param.getParam(serial);
        System.out.println("调用接口7072参数:\n" + param);
        call(param);
    }

    public static void test8001(String serial) throws Exception {
        String param = Tx8001Param.getParam(serial);
        System.out.println("调用接口8001参数:\n" + param);
        call(param);
    }

    public static void test3002(String serial) throws Exception {
        String param = Tx3002Param.getParam(serial);
        System.out.println("调用接口3002参数:\n" + param);
        call(param);
    }

    public static void test1201(String serial) throws Exception {
        String param = Tx1201Param.getParam(serial);
        System.out.println("调用接口1201参数:\n" + param);
        call(param);
    }

    public static void test3104(String serial) throws Exception {
        String param = Tx3104Param.getParam(serial);
        System.out.println("调用接口3104参数:\n" + param);
        call(param);
    }

    public static void test3106(String serial) throws Exception {
        String param = Tx3106Param.getParam(serial);
        System.out.println("调用接口3106参数:\n" + param);
        call(param);
    }

    public static void test3107(String serial) throws Exception {
        String param = Tx3107Param.getParam(serial);
        System.out.println("调用接口3107参数:\n" + param);
        call(param);
    }

    public static void test3001(String serial) throws Exception {
        String param = Tx3001Param.getParam(serial);
        System.out.println("调用接口3001参数:\n" + param);
        call(param);
    }

    public static void test3103(String serial) throws Exception {
        String param = Tx3103Param.getParam(serial);
        System.out.println("调用接口3103参数:\n" + param);
        call(param);
    }

    /**
     * Http 调用
     *
     * @param json 请求Json
     * @return resultJson
     * @throws Exception IO异常、加解密异常
     */
    public static String call(String json) throws Exception {
        // 平台公钥路径
        String ssfPukPath = "F:/key/public-rsa.cer";
        // 调用方私钥路径
        String userCertPath = "F:/key/liuhe-rsa.pfx";

        // 1.参数签名并加密
        // (1)要加密的Json (2)调用方私钥证书 (3)私钥密码 (4)平台方公钥
        String encryptWithSign = PackageUtil.encryptAndSign(json, userCertPath, "123456", ssfPukPath);

        // 构建请求参数结构
        String paramJson = "{\"appNo\":\"LiuHe000001\",\"context\":\"" + encryptWithSign + "\"}";

        // 2.调用接口
        CloseableHttpClient httpClient;
        HttpPost httpPost;
        if (REMOTE) {
            httpClient = HttpsClientUtil.getHttpClient(true, true, "D:/tmp/server.crt");
            httpPost = new HttpPost("https://obsapi.nhgfc.com/connector/recvGateway/service"); // 远程测试
        } else {
            httpClient = HttpClientBuilder.create().build();
            httpPost = new HttpPost("http://127.0.0.1:8082/server-connector/recvGateway/service"); // 本地测试
        }

        httpPost.addHeader("Content-Type", "application/json");
        StringEntity stringEntity = new StringEntity(paramJson, "utf-8");
        httpPost.setEntity(stringEntity);
        CloseableHttpResponse response = httpClient.execute(httpPost);
        HttpEntity entity = response.getEntity();

        String resultString = entityUtil(entity);
        System.out.println("\nHttp调用结果：\n" + resultString + "\n");
        // 3.解密返回值
        // (1)密文 (2)私钥路径 (3)私钥密码
        String resultJson = PackageUtil.decrypt(resultString, userCertPath, "123456");
        System.out.println("返回值解密结果如下：\n" + resultJson);

        // 4.验证签名
        JSONObject resultJsonObject = JSON.parseObject(resultJson, Feature.OrderedField);
        String sign = resultJsonObject.getString("sign");
        String pkg = resultJsonObject.getString("pkg");
        // (1)签名值 (2)原文 (3)平台方公钥
        boolean b = PackageUtil.verifySign(sign, pkg, ssfPukPath);
        System.out.println("\n验证签名结果：" + b);

        // 5.结果输出
        JSONObject pkg1 = resultJsonObject.getJSONObject("pkg");
        JSONObject pkgBody = pkg1.getJSONObject("pkgBody");
        JSONObject resPkgHead = pkg1.getJSONObject("resPkgHead");
        System.out.println("\n应答公共报文头：");
        System.out.println(resPkgHead.toJSONString());
        System.out.println("应答报文体：");
        System.out.println(pkgBody.toJSONString());
        return resultJson;
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
}
