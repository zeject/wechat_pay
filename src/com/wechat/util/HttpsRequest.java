package com.wechat.util;

import com.wechat.config.Configure;
import com.wechat.service.IServiceRequest;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.ConnectionPoolTimeoutException;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.SocketTimeoutException;
import java.security.*;

public class HttpsRequest implements IServiceRequest {

    private static Log logger = new Log(HttpsRequest.class);

    private static CloseableHttpClient httpClient = buildHttpClient();

    private static int socketTimeout = 5000;

    private static int connectTimeout = 5000;

    private static int requestTimeout = 5000;

    public static CloseableHttpClient buildHttpClient() {

        try {
            KeyStore keyStore = KeyStore.getInstance("PKCS12");
            FileInputStream instream = new FileInputStream(new File(Configure.getCertLocalPath()));
            try {
                keyStore.load(instream,
                        Configure.getCertPassword().toCharArray());
            } finally {
                instream.close();
            }


            // Trust own CA and all self-signed certs
            SSLContext sslcontext = SSLContexts.custom()
                    .loadKeyMaterial(keyStore, Configure.getCertPassword().toCharArray())
                    .build();
//            // Allow TLSv1 protocol only
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
                    sslcontext,
                    new String[]{"TLSv1"},
                    null,
                    SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
            RequestConfig requestConfig = RequestConfig.custom()
                    .setConnectTimeout(connectTimeout)
                    .setConnectionRequestTimeout(requestTimeout)
                    .setSocketTimeout(socketTimeout).build();

            httpClient = HttpClients.custom()
                    .setDefaultRequestConfig(requestConfig)
                    .setSSLSocketFactory(sslsf)
                    .build();

            return httpClient;
        } catch (Exception e) {
            throw new RuntimeException("error create httpclient......", e);
        }
    }

    /**
     * 通过Https往API post xml数据
     *
     * @param url API地址
     *            要提交的XML数据对象
     * @return API回包的实际数据
     * @throws IOException
     * @throws KeyStoreException
     * @throws UnrecoverableKeyException
     * @throws NoSuchAlgorithmException
     * @throws KeyManagementException
     */

    public String sendPost(String url, Object object2Xml) throws UnsupportedEncodingException {

        String result = null;

        HttpPost httpPost = new HttpPost(url);

        String postDataXML = XMLParser.toXML(object2Xml);

        System.out.println(postDataXML);

        logger.info("API POST DATA:");
        logger.info(postDataXML);

        StringEntity postEntity = new StringEntity(postDataXML, "UTF-8");
        httpPost.addHeader("Content-Type", "text/xml");
        httpPost.setEntity(postEntity);

        logger.info("executing request" + httpPost.getRequestLine());

        try {
            HttpResponse response = httpClient.execute(httpPost);

            HttpEntity entity = response.getEntity();

            result = EntityUtils.toString(entity, "UTF-8");

        } catch (ConnectionPoolTimeoutException e) {
            logger.error("http get throw ConnectionPoolTimeoutException(wait time out)", e);

        } catch (ConnectTimeoutException e) {
            logger.error("http get throw ConnectTimeoutException", e);

        } catch (SocketTimeoutException e) {
            logger.error("http get throw SocketTimeoutException", e);

        } catch (Exception e) {
            logger.error("http get throw Exception", e);

        } finally {
            httpPost.releaseConnection();
        }

        return result;
    }

}
