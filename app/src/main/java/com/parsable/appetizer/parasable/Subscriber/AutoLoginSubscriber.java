package com.parsable.appetizer.parasable.Subscriber;
import com.parsable.appetizer.parasable.Model.ApiJsonPojo.AuthToken;
import com.parsable.appetizer.parasable.ParsableEnum;
import com.parsable.appetizer.parasable.Repository.IRepository;
import com.parsable.appetizer.parasable.View.ISendDataScreen;

import rx.Subscriber;

/**
 * Created by Davix on 3/11/16.
 */

public class AutoLoginSubscriber<T> extends Subscriber<T> {

    private ISendDataScreen sendDataScreen;
    private ParsableEnum.actionName actionName = ParsableEnum.actionName.Login;

    public AutoLoginSubscriber(ISendDataScreen sendDataScreen) {
        this.sendDataScreen = sendDataScreen;
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {

        if(this.sendDataScreen!=null){
            sendDataScreen.displayActionMessage(this.actionName, false);
        }

    }

    @Override
    public void onNext(T t) {

        if(this.sendDataScreen!=null){
            sendDataScreen.displayActionMessage(this.actionName, true);
        }

    }
}
