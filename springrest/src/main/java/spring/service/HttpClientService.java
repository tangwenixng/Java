package spring.service;

import okhttp3.*;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Created by twx on 2017/8/22.
 */
@Service("httpClientService")
public class HttpClientService {

    public static String doPost(String url,String postStr) {
        String res=null;

        OkHttpClient client = new OkHttpClient();
        RequestBody formBody = new FormBody.Builder()
                .add("XML", postStr)
                .build();
        Request request = new Request.Builder()
                .url(url)  // http://localhost:8888/
                .post(formBody)
                .build();
        try {
            Response response = client.newCall(request).execute();
            if (!response.isSuccessful()) {
                throw new IOException("服务器端错误: " + response);
            }
            res =  response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    /**
     * 获取会议状态
     * @param url
     * @param meetingKey
     * @return
     */
    public static String[] getMeetingStatusRes(String url,String meetingKey) {
        HttpUrl.Builder urlBuilder = HttpUrl.parse(url).newBuilder();
        urlBuilder.addQueryParameter("AT", "GS");
        urlBuilder.addQueryParameter("MK", meetingKey);
        String requestUrl = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(requestUrl)
                .build();
        OkHttpClient client = new OkHttpClient();
        try {
            Response response = client.newCall(request).execute();
            if (!response.isSuccessful()) {
                throw new IOException("服务器端错误: " + response);
            }
            String result = response.body().string();
            String[] split = result.split("&");
            String gs = split[1].split("=")[1];
            String ss = split[split.length-1].split("=")[1];

            String[] arr = new String[2];
            arr[0] = gs;
            arr[1] = ss;
            return  arr;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;
    }
}
