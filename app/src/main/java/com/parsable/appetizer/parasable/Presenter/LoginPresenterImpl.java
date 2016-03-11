package com.parsable.appetizer.parasable.Presenter;

import com.parsable.appetizer.parasable.Event.LoginEvent;
import com.parsable.appetizer.parasable.Event.CreateAccountEvent;
import com.parsable.appetizer.parasable.Repository.IDataStore;

import org.jetbrains.annotations.NotNull;

import okhttp3.ResponseBody;
import rx.Observable;

/**
 * Created by Davix on 3/10/16.
 */
public class LoginPresenterImpl implements ILoginPresenter{

    IDataStore repository;

    public LoginPresenterImpl(IDataStore repository) {
        this.repository = repository;
    }

    @NotNull
    @Override
    public Observable<ResponseBody> loginAction(@NotNull LoginEvent event) {
        return null;
    }

    @NotNull
    @Override
    public Observable<ResponseBody> signUpAction(@NotNull CreateAccountEvent event) {
        return null;
    }

    @NotNull
    @Override
    public Observable<ResponseBody> logOutAction() {
        return null;
    }
}
