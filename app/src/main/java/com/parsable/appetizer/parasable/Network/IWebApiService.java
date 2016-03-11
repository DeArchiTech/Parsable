package com.parsable.appetizer.parasable.Network;

import com.parsable.appetizer.parasable.Model.ApiJsonPojo.AuthToken;
import com.parsable.appetizer.parasable.Model.ApiJsonPojo.CreatApiPojo;
import com.parsable.appetizer.parasable.Model.ApiJsonPojo.LogOutApiPojo;
import com.parsable.appetizer.parasable.Model.ApiJsonPojo.LoginApiPojo;
import com.parsable.appetizer.parasable.Model.ApiJsonPojo.SendNumberApiPojo;
import com.parsable.appetizer.parasable.Model.ApiJsonPojo.SendTextApiPojo;

import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by Davix on 3/9/16.
 */
//Use ResponseBody of Okhttp3 because retrofit doesn't allow other types
public interface IWebApiService{

    @Headers("Content-Type:application/json")
    @POST("api/authentication")
    Observable<ResponseBody> createAccount(@Body CreatApiPojo pojo);

    @Headers("Content-Type:application/json")
    @POST("api/authentication")
    Observable<AuthToken> loginAccount(@Body LoginApiPojo pojo);

    @Headers("Content-Type:application/json")
    @POST("api/authentication")
    Observable<ResponseBody> logoutAccount(@Body LogOutApiPojo pojo);

    @Headers("Content-Type:application/json")
    @POST("api/candidatestore")
    Observable<ResponseBody> sendText(@Body SendTextApiPojo pojo);

    @Headers("Content-Type:application/json")
    @POST("api/candidatestore")
    Observable<ResponseBody> sendNumber(@Body SendNumberApiPojo pojo);

}
