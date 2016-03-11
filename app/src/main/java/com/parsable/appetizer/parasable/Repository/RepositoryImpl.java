package com.parsable.appetizer.parasable.Repository;

import com.parsable.appetizer.parasable.Event.LoginEvent;
import com.parsable.appetizer.parasable.Event.CreateAccountEvent;
import com.parsable.appetizer.parasable.Model.ApiJsonPojo.AuthToken;
import com.parsable.appetizer.parasable.Model.ApiJsonPojo.CreatApiPojo;
import com.parsable.appetizer.parasable.Model.ApiJsonPojo.LogOutApiPojo;
import com.parsable.appetizer.parasable.Model.ApiJsonPojo.LoginApiPojo;
import com.parsable.appetizer.parasable.Model.ApiJsonPojo.SendNumberApiPojo;
import com.parsable.appetizer.parasable.Model.ApiJsonPojo.SendTextApiPojo;
import com.parsable.appetizer.parasable.Network.IWebApiService;

import org.jetbrains.annotations.NotNull;

import okhttp3.ResponseBody;
import rx.Observable;

/**
 * Created by Davix on 3/10/16.
 */
public class RepositoryImpl implements IRepository{

    IWebApiService apiService;

    public RepositoryImpl(IWebApiService apiService) {
        this.apiService = apiService;
    }

    @NotNull
    @Override
    public Observable<ResponseBody> createAccountAction(@NotNull CreateAccountEvent event) {

        CreatApiPojo pojo = new CreatApiPojo();
        pojo.setEmail(event.email);
        pojo.setPassword(event.password);
        return this.apiService.createAccount(pojo);

    }

    @NotNull
    @Override
    public Observable<AuthToken> loginAction(@NotNull LoginEvent event) {

        LoginApiPojo pojo = new LoginApiPojo();
        pojo.setEmail(event.email);
        pojo.setPassword(event.password);
        return this.apiService.loginAccount(pojo);

    }

    @NotNull
    @Override
    public Observable<ResponseBody> logOut() {
        return this.apiService.logoutAccount(new LogOutApiPojo());
    }

    @NotNull
    @Override
    public Observable<ResponseBody> sendText(@NotNull String text) {
        return this.apiService.sendText(new SendTextApiPojo(text));
    }

    @NotNull
    @Override
    public Observable<ResponseBody> sendNumber(@NotNull String text) {
        return this.apiService.sendNumber(new SendNumberApiPojo(text));
    }
}
