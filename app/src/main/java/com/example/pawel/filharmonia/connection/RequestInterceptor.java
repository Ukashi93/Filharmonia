package com.example.pawel.filharmonia.connection;

import java.io.IOException;
import okhttp3.Request;
import okhttp3.Response;

public class RequestInterceptor implements okhttp3.Interceptor{

    public static final String APP_ID="pl.edu.fiharmonia";
    public static final String HOST = "api.stg.appsoup.io";

    @Override
    public Response intercept(Chain chain) throws IOException {
        okhttp3.HttpUrl url=chain.request().url();
        if(url.host().equals(HOST)){
            Request newRequest=chain.request().newBuilder()
                    .addHeader("app-id", APP_ID)
                    .addHeader("token","37e22d38c4a1380eee9fc944758f628f")
                    .build();

            return chain.proceed(newRequest);
        }
        else {
            return chain.proceed(chain.request());
        }
    }
}
