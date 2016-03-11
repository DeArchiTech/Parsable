package com.parsable.appetizer.parasable.Presenter;

import com.parsable.appetizer.parasable.ParsableEnum;
import com.parsable.appetizer.parasable.View.ILoginView;

import rx.Subscriber;

/**
 * Created by Davix on 3/10/16.
 */
public class LoginSubscriber<T> extends Subscriber<T> {

    ILoginView view ;
    ParsableEnum.actionName action;

    public LoginSubscriber(ILoginView view, ParsableEnum.actionName action) {
        this.view = view;
        this.action = action;
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {

        this.view.displayActionAndResult(this.action, false);
    }

    @Override
    public void onNext(T t) {

        this.view.displayActionAndResult(this.action, true );

    }
}
