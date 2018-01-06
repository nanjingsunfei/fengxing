package cn.njupt.http;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by sunfei on 2017/11/28.
 */
public class httpConnection {

    public static void main(String[] args) {
        Map<String, String> params = new HashMap<String, String>();
        List<NameValuePair> qparams = new LinkedList<NameValuePair>();
        if (params != null && params.size() > 0) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                qparams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
        }
        String q = URLEncodedUtils.format(qparams, "UTF-8");
        String uri = "http://www.dianping.com?" + q;
        HttpGet httpGet = new HttpGet(uri);
        RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(2000).setConnectTimeout(2000).
                setSocketTimeout(2000).
                build();
        httpGet.setConfig(requestConfig);

        HttpClient httpClient = HttpClients.custom().setRetryHandler(new HttpRequestRetryHandler() {
            public boolean retryRequest(IOException exception, int executionCount, HttpContext context) {
                return false;
            }
        }).build();

        try {
            HttpResponse httpResponse = httpClient.execute(httpGet);
            if (httpResponse == null || httpResponse.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
                return;
            }
            String result = EntityUtils.toString(httpResponse.getEntity());

            JSONObject jsonObject = JSONObject.parseObject(result);

            jsonObject.getString("");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void httpPost() {
        try {
            Map<String, String> params = new HashMap<String, String>();
            List<NameValuePair> qparams = new LinkedList<NameValuePair>();
            if (params != null && params.size() > 0) {
                for (Map.Entry<String, String> entry : params.entrySet()) {
                    qparams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
                }
            }
            UrlEncodedFormEntity urlEncodedFormEntity = new UrlEncodedFormEntity(qparams, "UTF-8");
            HttpPost httpPost = new HttpPost("http://www.dianping.com");
            httpPost.setEntity(urlEncodedFormEntity);

            HttpClient httpClient = HttpClients.custom().build();

            HttpResponse httpResponse = httpClient.execute(httpPost);

            httpResponse.getStatusLine().getStatusCode();

        } catch (Exception e) {

        }

    }
}
