package com.liujiazhen.http.client;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;
import com.shanshoufu.api.util.PackageUtil;

/**
 * 加解密工具类Demo
 */
public class PackageDemo {
    public static void main(String[] args) throws Exception {
        // 平台公钥路径
        String ssfPukPath = "F:/key/public-rsa.cer";
        // 调用方私钥路径
        String userCertPath = "F:/key/liuhe-rsa.pfx";

        // 加密字符串必须为Json结构
        String pkgJson = "{\"aa\":\"bb\"}";
        // 加密并签名：(1)要加密的Json (2)调用方私钥证书 (3)私钥密码 (4)平台方公钥
        String encryptWithSign = PackageUtil.encryptAndSign(pkgJson, userCertPath, "123456", ssfPukPath);
        System.out.println("签名并加密结果：\n" + encryptWithSign);


        // 字符串是加密后的结果
        String str = "MIAGCSqGSIb3DQEHA6CAMIACAQAxgeQwgeECAQAwSjA9MQswCQYDVQQGEwJDTjERMA8GA1UECAwIU0hBTkRPTkcxCzAJBgNVBAcMAlFEMQ4wDAYDVQQKDAVMSVVIRQIJAPI1ADTgkAq2MA0GCSqGSIb3DQEBAQUABIGAHY4og6KErZoJHl4AYRf4Xza2hp0cH9cA1qzf085f+eb6OvKJb6QnsO0jUhhDLa/uWmpjCSvP3PVMkp7IWvIbjob+qcqTCVJ+yF/uX0lmJXxm6tKF+zUcX688gt1TAHoVa9cW0XK2Vo0gkRqNv5UNNfBU9IwZlDbFrkdsJLWGIjEwgAYJKoZIhvcNAQcBMAwGCCqGSIb3DQMEBQCggASCA+gseu2aMh3/w1GxdIU+NXS2XwFa0Azln66yVGS80Sh6BiobADINo5qJtS2JpR4pvyIMz0aXWK/YuEFbaZ4+X2NVyXY2N9A1M3ZLMMRAYvoat8f4UEcSBvCh7c+Pu2M3FlT4IkUH6VXw04f3wUhWBwvtPgky0DsUDdFLE52QtnIAlkYCwc6ZSTra2dA8Aw4RASZcDV1z/htf8Zvhe4m3vFYO2dm1j0WmWpHickzaYGvIHMmksj/OP/Vm2J4le5gXw2FVau3Sv2gvaOr8vRg+dBrNJlu2To8+Jc2VFMftqFWgZeEO6ZQlq1jKD3wIQTk4odx3tXR0Ud4WHP+xect9sfX9IVuVvpGy+e1mhgeNTom9nmXh5OTIWrULPbDbND80xUvaWX+HbaSvHR3f2y5eTFIdlSnkMW/ETgv3nGjKkOZHaB+5kYV3yKua0IflCHmtMhOsTHirxinjPcJ64wDD80+8D3EdUIs/FgvMs4P4j2h6/W/VXCs4YwmLYBLY3V3oFwYcmo6dUKuUVj6t4ZzYr1pQ4tZrXAbjlIMz01JplH0QLMDZVOMuLl8HFdpEkMVLDdRP95SBy4BNNCNzCbNIQnjsdDERh/o++yfbuCkL13T1WAOxbPE40R4iQhxHUnNjaQW9Vg+wOlsIBY0vgU3Ib0T1ueBRwS53EskkcKpchxctsTm9zENV3ezngB+NZOyIhDXdWZ7oImYG3R80hpX8rpYgXzcLffyTkkXJwhiZeOCCavBh6vAguRhZr4O5nVyiLFFkUSQtcCXBCckrf8KFRRNEdyd/oOvrWwQJ6X4R2+AyCjkR9B8JlwMby7C/+hvMaNn9NU/A1qkrbtwgBGvNS83Fl5zeCzAnYsKd7uXOWnLpFsnS3OLCbaQmMURJEjVloKNqkRmtg2Y9KHrEcBYNNZJU5+nxn67f6hooCbsTnPamIKc9HvF3s84RUAyYETGdFQg2n1QuMgbrUQhfVwpD6xqloDYFQmfJI5xYVnpM8HHhQOoyZ79Cv04La2/sBfEfXchN5jItdk7cOzjoMMHZNJSx4k/vjQcWESQM7S56uLonh+0i5WOlN1735AvHG1TxwoXOdP1lEPhL9Ig0FZQ2HnUJz0PszFuroR+USbLVK2Ch8FM50yKEFegNLz9ky9KNjKJ//V/haObBv2TRMfhIhPeNTFFzXRL9bqBnNhlXFK49chqjullVOwPYLW6ZtIO72wp0H0v5275lmfie5SVhSCO0Slj4uNWa3nXzEL8L3gOhhxy9RxdfuOYvphVB/K3Y9vcJLL8sZ1Pt+oxfmHD7+prTBOSlHy+owwv5Vdb4LDUJj4h4G1HRF77TBIGDJclp+ST+k6+qSyuAzGiCsuKS7IdgHSl6YIBei/nk/4F7UEUBRuXMuCiTr/W7JWDufaOMYQ9WdZNiJKuNS9pwKFgxYm/+PqxkZ68nl5S36NBoQwzUuPBuCurlvyWrWi4xHyG1oYj6fmjEubtlsg7o65qsap+ukV+CuglJrqfb+0etDbwAAAAAAAAAAAAA";
        // 解密方法
        String decrypt = PackageUtil.decrypt(str, userCertPath, "123456");
        System.out.println("解密结果：\n" + decrypt);


        // 验证签名
        JSONObject resultJsonObject = JSON.parseObject(decrypt, Feature.OrderedField);
        String sign = resultJsonObject.getString("sign");
        String pkg = resultJsonObject.getString("pkg");

        boolean b = PackageUtil.verifySign(sign, pkg, ssfPukPath);
        System.out.println("验证签名结果：\n" + b);
    }
}
