package com.parsable.appetizer.parasable.Presenter;

import com.parsable.appetizer.parasable.Event.LoginEvent;
import com.parsable.appetizer.parasable.Event.CreateAccountEvent;
import com.parsable.appetizer.parasable.Model.ApiJsonPojo.AuthToken;
import com.parsable.appetizer.parasable.Repository.IDataStore;
import com.parsable.appetizer.parasable.Repository.IRepository;

import org.jetbrains.annotations.NotNull;

import okhttp3.ResponseBody;
import rx.Observable;

/**
 * Created by Davix on 3/10/16.
 */
public class LoginPresenterImpl implements ILoginPresenter{

    IRepository repository;

    public LoginPresenterImpl(IRepository repository) {
        this.repository = repository;
    }

    @NotNull
    @Override
    public Observable<AuthToken> loginAction(@NotNull LoginEvent event) {

        return this.repository.loginAction(event);

    }

    @NotNull
    @Override
    public Observable<ResponseBody> createAccountAction(@NotNull CreateAccountEvent event) {
        return this.repository.createAccountAction(event);
    }

    @NotNull
    @Override
    public Observable<ResponseBody> logOutAction() {
        return this.repository.logOut();
    }

}
