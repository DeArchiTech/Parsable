package com.parsable.appetizer.parasable;

import com.parsable.appetizer.parasable.Event.CreateAccountEvent;
import com.parsable.appetizer.parasable.Event.LoginEvent;
import com.parsable.appetizer.parasable.Model.ApiJsonPojo.AuthToken;
import com.parsable.appetizer.parasable.Presenter.ILoginPresenter;
import com.parsable.appetizer.parasable.Presenter.LoginSubscriber;
import com.parsable.appetizer.parasable.View.ILoginView;

import org.jetbrains.annotations.NotNull;

import okhttp3.ResponseBody;
import rx.Subscriber;

/**
 * Created by Davix on 3/10/16.
 */
public class MockLoginPresenter implements ILoginPresenter{

    private ILoginView view ;

    public MockLoginPresenter(ILoginView view) {
        this.view = view;
    }

    @NotNull
    @Override
    public Subscriber<ResponseBody> createAccountAction(@NotNull CreateAccountEvent event) {
        return new LoginSubscriber<ResponseBody>(this.view, ParsableEnum.actionName.CreateAccount);

    }

    @NotNull
    @Override
    public Subscriber<AuthToken> loginAction(@NotNull LoginEvent event) {
        return new LoginSubscriber<AuthToken>(this.view, ParsableEnum.actionName.Login);
    }

    @NotNull
    @Override
    public Subscriber<ResponseBody> logOutAction() {
        return new LoginSubscriber<ResponseBody>(this.view, ParsableEnum.actionName.LogOut);
    }
}
