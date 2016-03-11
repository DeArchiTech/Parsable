package com.parsable.appetizer.parasable.Presenter;

import com.parsable.appetizer.parasable.Event.LoginEvent;
import com.parsable.appetizer.parasable.Event.CreateAccountEvent;
import com.parsable.appetizer.parasable.Model.ApiJsonPojo.AuthToken;
import com.parsable.appetizer.parasable.ParsableEnum;
import com.parsable.appetizer.parasable.Repository.IRepository;
import com.parsable.appetizer.parasable.View.ILoginView;

import org.jetbrains.annotations.NotNull;

import okhttp3.ResponseBody;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by Davix on 3/10/16.
 */
public class LoginPresenterImpl implements ILoginPresenter{

    IRepository repository;
    ILoginView view;

    public LoginPresenterImpl(IRepository repository, ILoginView view) {
        this.repository = repository;
        this.view = view;
    }

    @NotNull
    @Override
    public Subscriber<AuthToken> loginAction(@NotNull LoginEvent event) {

        Subscriber<AuthToken> subscriber = new LoginSubscriber<AuthToken>(this.view, ParsableEnum.actionName.Login);
        Observable<AuthToken> observable = this.repository.loginAction(event);
        observable.subscribe(subscriber);
        return subscriber;
    }

    @NotNull
    @Override
    public Subscriber<ResponseBody> createAccountAction(@NotNull CreateAccountEvent event){

        Subscriber<ResponseBody> subscriber = new LoginSubscriber<ResponseBody>(this.view,ParsableEnum.actionName.CreateAccount);
        Observable<ResponseBody> observable = this.repository.createAccountAction(event);
        observable.subscribe(subscriber);
        return subscriber;

    }

    @NotNull
    @Override
    public Subscriber<ResponseBody> logOutAction() {

        Subscriber<ResponseBody> subscriber = new LoginSubscriber<ResponseBody>(this.view,ParsableEnum.actionName.LogOut);
        Observable<ResponseBody> observable = this.repository.logOut();
        observable.subscribe(subscriber);
        return subscriber;

    }

}
