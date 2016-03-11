package com.parsable.appetizer.parasable.Network;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.parsable.appetizer.parasable.Model.ApiJsonPojo.AuthToken;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by Davix on 3/10/16.
 */
public class RetrofitHelper {

    public IWebApiService buildWebApiService(){

        return buildWebApiService(null);

    }

    public IWebApiService buildWebApiService(AuthToken token){

        ParsableInterceptor interceptor = new ParsableInterceptor();

        if(token!=null){
            interceptor = new ParsableInterceptor(token);
        }

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://54.186.152.100")
                .client(client)
                .addConverterFactory(JacksonConverterFactory.create(new ObjectMapper()))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        return retrofit.create(IWebApiService.class);
    }
}
