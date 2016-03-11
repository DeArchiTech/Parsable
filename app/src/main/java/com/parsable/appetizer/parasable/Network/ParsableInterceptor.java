package com.parsable.appetizer.parasable.Network;

import android.support.annotation.NonNull;

import com.parsable.appetizer.parasable.Model.ApiJsonPojo.AuthToken;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Davix on 3/9/16.
 */
public class ParsableInterceptor implements Interceptor{

    private Map<String, String> headerMap;

    public ParsableInterceptor() {
        this.headerMap = new HashMap<String, String>();
        this.headerMap.put("Content-Type", "application/json");
    }

    public ParsableInterceptor(AuthToken token){

        this.headerMap = new HashMap<String, String>();
        if(token!=null){
            this.headerMap.put("Authorization" , "Token " + token.AuthToken);
        }
        this.headerMap.put("Content-Type", "application/json");

    }

    @Override
    public Response intercept(Chain chain)
            throws IOException {

        Request request = chain.request();
        Request.Builder builder = request.newBuilder();

        for (Map.Entry<String, String> entry : headerMap.entrySet()) {
            builder.addHeader(entry.getKey(), entry.getValue());
        }

        request = builder.build();
        Response response = chain.proceed(request);
        return response;
    }
}
