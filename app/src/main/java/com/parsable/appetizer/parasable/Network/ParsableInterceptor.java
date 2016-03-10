package com.parsable.appetizer.parasable.Network;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Davix on 3/9/16.
 */
public class ParsableInterceptor implements Interceptor{

    @Override
    public Response intercept(Chain chain)
            throws IOException {

        Request request = chain.request();
        request = request.newBuilder()
                .addHeader("deviceplatform", "android")
                .removeHeader("User-Agent")
                .addHeader("User-Agent", "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:38.0) Gecko/20100101 Firefox/38.0")
                .build();
        Response response = chain.proceed(request);
        return response;
    }

}
