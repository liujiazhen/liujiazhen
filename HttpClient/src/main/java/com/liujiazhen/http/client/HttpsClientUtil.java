package com.liujiazhen.http.client;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.Arrays;

/**
 * Https客户端工具类
 */
public class HttpsClientUtil {
    private HttpsClientUtil() {
    }

    public static CloseableHttpClient getHttpClient(boolean isHttps, boolean ssl, String certPath) {
        CloseableHttpClient httpClient;
        if (isHttps) {
            SSLConnectionSocketFactory sslSocketFactory;
            try {
                if (ssl) {
                    // 如果需要证书检验的话
                    // 证书
                    InputStream ca = new FileInputStream(new File(certPath));
                    // 证书的别名，即:key。 注:cAalias只需要保证唯一即可，不过推荐使用生成keystore时使用的别名。
                    String cAalias = System.currentTimeMillis() + "" + new SecureRandom().nextInt(1000);
                    sslSocketFactory = getSocketFactory(true, ca, cAalias);
                } else {
                    /// 如果不作证书校验的话
                    sslSocketFactory = getSocketFactory(false, null, null);
                }
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            httpClient = HttpClientBuilder.create().setSSLSocketFactory(sslSocketFactory).build();
            return httpClient;
        } else {
            httpClient = HttpClientBuilder.create().build();
            return httpClient;
        }
    }

    /**
     * HTTPS辅助方法, 为HTTPS请求 创建SSLSocketFactory实例、TrustManager实例
     *
     * @param needVerifyCa  是否需要检验CA证书(即:是否需要检验服务器的身份)
     * @param caInputStream CA证书。(若不需要检验证书，那么此处传null即可)
     * @param cAalias       别名。(若不需要检验证书，那么此处传null即可)
     *                      注意:别名应该是唯一的， 别名不要和其他的别名一样，否者会覆盖之前的相同别名的证书信息。别名即key-value中的key。
     * @return SSLConnectionSocketFactory实例
     * 异常信息
     * @date 2019/6/11 19:52
     */
    private static SSLConnectionSocketFactory getSocketFactory(boolean needVerifyCa, InputStream caInputStream, String cAalias)
            throws Exception {
        X509TrustManager x509TrustManager;
        // https请求，需要校验证书
        if (needVerifyCa) {
            KeyStore keyStore = getKeyStore(caInputStream, cAalias);
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init(keyStore);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            if (trustManagers.length != 1 || !(trustManagers[0] instanceof X509TrustManager)) {
                throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
            }
            x509TrustManager = (X509TrustManager) trustManagers[0];
            // 这里传TLS或SSL其实都可以的
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, new TrustManager[]{x509TrustManager}, new SecureRandom());
            return new SSLConnectionSocketFactory(sslContext);
        } else {
            SSLContext sslContext = SSLContext.getInstance("TLS");
            TrustManager[] tm = {ignoreCertificationTrustManger};
            sslContext.init(null, tm, new SecureRandom());
            return new SSLConnectionSocketFactory(sslContext);
        }

    }

    /**
     * Ignore Certification
     */
    private static TrustManager ignoreCertificationTrustManger = new X509TrustManager() {
        private java.security.cert.X509Certificate[] certificates;

        @Override
        public void checkClientTrusted(java.security.cert.X509Certificate certificates[], String authType) throws CertificateException {
            if (this.certificates == null) {
                this.certificates = certificates;
            }
        }

        @Override
        public void checkServerTrusted(java.security.cert.X509Certificate[] ax509certificate, String s) throws CertificateException {
            if (this.certificates == null) {
                this.certificates = ax509certificate;
            }
        }

        @Override
        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
            return new java.security.cert.X509Certificate[0];
        }
    };

    /**
     * 获取(密钥及证书)仓库
     * 注:该仓库用于存放 密钥以及证书
     *
     * @param caInputStream CA证书(此证书应由要访问的服务端提供)
     * @param cAalias       别名
     *                      注意:别名应该是唯一的， 别名不要和其他的别名一样，否者会覆盖之前的相同别名的证书信息。别名即key-value中的key。
     * @return 密钥、证书 仓库
     * @date 2019/6/11 18:48
     */
    private static KeyStore getKeyStore(InputStream caInputStream, String cAalias)
            throws Exception {
        // 证书工厂
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
        // 秘钥仓库
        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        keyStore.load(null);
        keyStore.setCertificateEntry(cAalias, certificateFactory.generateCertificate(caInputStream));
        return keyStore;
    }
}
