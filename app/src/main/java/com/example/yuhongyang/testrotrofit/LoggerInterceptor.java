package com.example.yuhongyang.testrotrofit;

import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by yuhong.yang on 2018/1/30.
 */

    public class LoggerInterceptor implements Interceptor {
    private static final String TAG = "SERVER";
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        long t1 = System.nanoTime();
        Log.d(TAG,String.format("sendingRequest: %s on %s%n%s",
                request.url(),chain.connection(),request.headers()));
        Request overrideRequest = request.newBuilder().addHeader("User-Agent","Android").build();
        Response response = chain.proceed(overrideRequest);
        long t2 = System.nanoTime();
        Log.d(TAG,String.format("receive: %s in  %.1fms%n%s",
                response.request().url(),(t2-t1)/1e6d,response.headers()));
        return response;
    }
}
