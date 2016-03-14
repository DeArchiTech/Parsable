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
import com.parsable.appetizer.parasable.Network.RetrofitHelper;
import com.parsable.appetizer.parasable.Util.StringHelper;

import org.jetbrains.annotations.NotNull;
import okhttp3.ResponseBody;
import rx.Observable;

/**
 * Created by Davix on 3/10/16.
 */
public class RepositoryImpl implements IRepository{

    IWebApiService apiService;

    public RepositoryImpl() {
        this.apiService = new RetrofitHelper().buildWebApiService();
    }

    public RepositoryImpl(IWebApiService apiService) {
        this.apiService = apiService;
    }

    public RepositoryImpl(AuthToken token){
        this.apiService = new RetrofitHelper().buildWebApiService(token);

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
        return this.apiService.loginAccount(pojo)
                .flatMap(token -> saveAuthToken(token));

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

    @NotNull
    @Override
    public Observable<AuthToken> saveAuthToken(@NotNull AuthToken token) {

        //Save and rebuild service
        if(token != null){

            IUserData dataStore = CacheData.getInstance();
            if(dataStore !=null) {
                dataStore.cacheAuthTotken(token);
            }

        }
        this.rebuildWebService(token);
        return Observable.defer(() -> Observable.just(token));

    }

    @NotNull
    @Override
    public Observable<AuthToken> loadLastAuthToken() {

        IUserData dataStore = CacheData.getInstance();
        if(dataStore !=null) {
            final AuthToken token = dataStore.readCachedAuthToken();
            return Observable.defer(() -> Observable.just(token));
        }else{
            return Observable.defer(() -> Observable.just(null));
        }

    }

    @Override
    public Observable<AuthToken> autoLogin() {

        LoginApiPojo pojo = new LoginApiPojo();
        pojo.setEmail(new StringHelper().createLoginEmail());
        pojo.setPassword(new StringHelper().createLoginPassword());
        return this.apiService.loginAccount(pojo)
                        .flatMap(token -> saveAuthToken(token));

    }

    public void rebuildWebService(AuthToken token){

        this.apiService = new RetrofitHelper().buildWebApiService(token);

    }

}
