package com.zeus.utils;


/*
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.util.DigestUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
*/
/**
 * @Description
 * @author:wangdi
 * @date:2019/1/7
 * @ver:1.0
 *//*

public class WXAuthUtil {
    public static final String APPID="wx9b39273dce55dc2f";
    public static final String APPSECRET ="06f175852111045f81ebf62db28a44a0";
    private static final String TOKEN = "immco";
   public static JSONObject doGetJson(String url) throws ClientProtocolException, IOException {
        JSONObject jsonObject = null;
        DefaultHttpClient client = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);
        HttpResponse response = client.execute(httpGet);
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            String result = EntityUtils.toString(entity, "UTF-8");
            jsonObject = JSONObject.fromObject(result);
        }
        httpGet.releaseConnection();
        return jsonObject;
    }
}
   

}
*/
