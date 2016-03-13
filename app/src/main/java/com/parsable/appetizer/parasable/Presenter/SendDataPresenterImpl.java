package com.parsable.appetizer.parasable.Presenter;

import com.parsable.appetizer.parasable.Event.SendDataEvent;
import com.parsable.appetizer.parasable.Model.ApiJsonPojo.AuthToken;
import com.parsable.appetizer.parasable.Repository.IRepository;
import com.parsable.appetizer.parasable.Subscriber.AutoLoginSubscriber;
import com.parsable.appetizer.parasable.Subscriber.SendTextSubscriber;
import com.parsable.appetizer.parasable.Util.StringHelper;
import com.parsable.appetizer.parasable.View.ISendDataScreen;

import org.jetbrains.annotations.NotNull;

import okhttp3.ResponseBody;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Davix on 3/11/16.
 */
public class SendDataPresenterImpl implements ISendDataPresenter{

    private IRepository repository;

    public SendDataPresenterImpl(IRepository repository){
        this.repository = repository;
    }

    @Override
    public void sendDataEvent(@NotNull SendDataEvent event, @NotNull ISendDataScreen view) {

        String userInput = event.text;

        Observable<ResponseBody> observable;
        Subscriber<ResponseBody> subscriber = new SendTextSubscriber<ResponseBody>(view);

        if(new StringHelper().inputIsANumber(userInput)){

            observable = this.repository.sendNumber(userInput);

        }else{

            observable = this.repository.sendText(userInput);

        }

        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(subscriber);

    }

    @Override
    public void autoLoginEvent(@NotNull AutoLoginSubscriber<AuthToken> subcriber) {

        Observable<AuthToken> observable = this.repository.autoLogin();
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(subcriber);
    }
}
