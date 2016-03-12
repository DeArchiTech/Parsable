package com.parsable.appetizer.parasable.Presenter;

import com.parsable.appetizer.parasable.Event.SendNumberEvent;
import com.parsable.appetizer.parasable.Event.SendTextEvent;
import com.parsable.appetizer.parasable.Model.ApiJsonPojo.SendTextApiPojo;
import com.parsable.appetizer.parasable.Repository.IRepository;
import com.parsable.appetizer.parasable.Subscriber.SendNumberSubscriber;
import com.parsable.appetizer.parasable.Subscriber.SendTextSubscriber;
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
    public void sendTextEvent(@NotNull SendTextEvent event, @NotNull Subscriber<ResponseBody> subscriber) {

        Observable<ResponseBody> observable = this.repository.sendText(event.text);
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(subscriber);

    }

    @Override
    public void sendNumberEvent(@NotNull SendNumberEvent event, @NotNull Subscriber<ResponseBody> subscriber) {

        Observable<ResponseBody> observable = this.repository.sendNumber(event.text);
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(subscriber);
    }

}
