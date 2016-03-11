package com.parsable.appetizer.parasable;

import com.parsable.appetizer.parasable.Model.ApiJsonPojo.AuthToken;
import com.parsable.appetizer.parasable.Model.ApiJsonPojo.CreatApiPojo;
import com.parsable.appetizer.parasable.Model.ApiJsonPojo.LogOutApiPojo;
import com.parsable.appetizer.parasable.Model.ApiJsonPojo.LoginApiPojo;
import com.parsable.appetizer.parasable.Model.ApiJsonPojo.SendNumberApiPojo;
import com.parsable.appetizer.parasable.Model.ApiJsonPojo.SendTextApiPojo;
import com.parsable.appetizer.parasable.Network.IWebApiService;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import rx.Observable;

/**
 * Created by Davix on 3/10/16.
 */
public class MockWebApiService implements IWebApiService{

    @Override
    public Observable<ResponseBody> createAccount(@Body CreatApiPojo pojo) {
        return Observable.just(ResponseBody.create(MediaType.parse(""), ""));
    }

    @Override
    public Observable<AuthToken> loginAccount(@Body LoginApiPojo pojo) {
        return null;
    }

    @Override
    public Observable<ResponseBody> logoutAccount(@Body LogOutApiPojo pojo) {
        return null;
    }

    @Override
    public Observable<ResponseBody> sendText(@Body SendTextApiPojo pojo) {
        return null;
    }

    @Override
    public Observable<ResponseBody> sendNumber(@Body SendNumberApiPojo pojo) {
        return null;
    }
}
