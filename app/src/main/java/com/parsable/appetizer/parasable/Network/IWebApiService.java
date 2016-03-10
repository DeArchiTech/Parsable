package com.parsable.appetizer.parasable.Network;

import com.parsable.appetizer.parasable.Model.ApiJsonPojo.IApiJsonPojo;

import okhttp3.Response;
import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by Davix on 3/9/16.
 */
public interface IWebApiService {

    @POST("/api/authentication")
    public Observable<Response> createAccount(@Body IApiJsonPojo body);

    @POST("/api/authentication")
    public Observable<Response> loginAccount(@Body IApiJsonPojo body);

    @POST("/api/authentication")
    public Observable<Response> logOutAccount(@Body IApiJsonPojo body);

    @POST("/candidatestore/")
    public Observable<Response> sendText(@Body IApiJsonPojo body);

    @POST("/candidatestore/")
    public Observable<Response> sendNum(@Body IApiJsonPojo body);
}
