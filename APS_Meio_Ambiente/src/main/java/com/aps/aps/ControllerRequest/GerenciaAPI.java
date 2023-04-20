package com.aps.aps.ControllerRequest;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class GerenciaAPI {

    private String baseURL = "https://api.openaq.org";
    public String GET(String strURI) {
        try {
            OkHttpClient client;
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.connectTimeout(30, TimeUnit.SECONDS);
            builder.readTimeout(60, TimeUnit.SECONDS);
            builder.writeTimeout(30, TimeUnit.SECONDS);

            Request request;
            request = new Request.Builder().url(baseURL + strURI).get().build();

            client = builder.build();

            Response response = client.newCall(request).execute();

            String jsonString = response.body().string();

            return jsonString;
        }
        catch (IOException e) {
            return "";
        }
    }
}
