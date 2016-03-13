package com.parsable.appetizer.parasable.Subscriber;

import com.parsable.appetizer.parasable.Model.ApiJsonPojo.AuthToken;
import com.parsable.appetizer.parasable.ParsableEnum;
import com.parsable.appetizer.parasable.View.ILoginView;

import rx.Subscriber;

/**
 * Created by Davix on 3/12/16.
 */
public class PushDataSubscriber<T> extends Subscriber<AuthToken> {

    ILoginView view ;
    ParsableEnum.actionName action = ParsableEnum.actionName.ReadAuthToken;

    public PushDataSubscriber(ILoginView view) {
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
    public void onNext(AuthToken authToken) {

        if(this.view !=null && authToken !=null){
            this.view.pushSendDataActivity(authToken);
        }

    }

    public void setView(ILoginView view) {
        this.view = view;
    }

}
