package com.parsable.appetizer.parasable.Subscriber;

import com.parsable.appetizer.parasable.ParsableEnum;
import com.parsable.appetizer.parasable.View.ILoginView;

import rx.Subscriber;

/**
 * Created by Davix on 3/10/16.
 */
public class LoginSubscriber<T> extends Subscriber<T> {

    ILoginView view ;
    ParsableEnum.actionName action = ParsableEnum.actionName.Login;

    public LoginSubscriber(ILoginView view) {
        this.view = view;
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {

        if(this.view !=null){
            this.view.displayActionAndResult(this.action, false);
        }
    }

    @Override
    public void onNext(T t) {

        if(this.view != null){
            this.view.displayActionAndResult(this.action, true );
        }

    }

    public void setView(ILoginView view) {
        this.view = view;
    }
}
