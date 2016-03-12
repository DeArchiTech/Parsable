package com.parsable.appetizer.parasable.Presenter;

import com.parsable.appetizer.parasable.Event.LoginEvent;
import com.parsable.appetizer.parasable.Event.CreateAccountEvent;
import com.parsable.appetizer.parasable.Model.ApiJsonPojo.AuthToken;
import com.parsable.appetizer.parasable.Repository.IRepository;
import org.jetbrains.annotations.NotNull;

import okhttp3.ResponseBody;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Davix on 3/10/16.
 */
public class LoginPresenterImpl implements ILoginPresenter{

    IRepository repository;

    public LoginPresenterImpl(IRepository repository) {
        this.repository = repository;
    }

    @Override
    public void createAccountAction(@NotNull CreateAccountEvent event, @NotNull Subscriber<ResponseBody> subscriber) {

        Observable<ResponseBody> observable = this.repository.createAccountAction(event);
        observable
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(subscriber);

    }

    @Override
    public void loginAction(@NotNull LoginEvent event, @NotNull Subscriber<AuthToken> subscriber) {

        Observable<AuthToken> observable = this.repository.loginAction(event);
        observable
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(subscriber);

    }

    @Override
    public void logOutAction(@NotNull Subscriber<ResponseBody> subscriber) {

        Observable<ResponseBody> observable = this.repository.logOut();
        observable
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(subscriber);

    }

}
