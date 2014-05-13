package com.example.PracticeDemo.util;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @Description: User: Administrator
 * Date: 14-5-13
 * Time: 16:49
 */
public class HttpUtils {

    /**
     * @param url
     * @param encoding
     * @return
     */
    public static String post(String url, String encoding) {
        String result = "";
        HttpClient httpClient = new DefaultHttpClient();
        try {
            HttpPost httpPost = new HttpPost(url);
            HttpResponse response = httpClient.execute(httpPost);
            if (response.getStatusLine().getStatusCode() == 200) {
                result = EntityUtils.toString(response.getEntity(), encoding);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            httpClient.getConnectionManager().shutdown();
        }
        return result;
    }

    public static String get(String url, String encoding) {
        String result = "";
        try {
            HttpClient httpClient = new DefaultHttpClient();
            HttpGet request = new HttpGet(url);
            HttpResponse response = httpClient.execute(request);
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                result = EntityUtils.toString(response.getEntity(), encoding);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
