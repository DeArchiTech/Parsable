package com.parsable.appetizer.parasable.Repository;

import com.parsable.appetizer.parasable.Enum;
import com.parsable.appetizer.parasable.Model.NumData;
import com.parsable.appetizer.parasable.Model.TextData;

import org.jetbrains.annotations.NotNull;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Davix on 3/8/16.
 */

//Note:
//Can't Block Main Thread
//Make sure its thread save
public class RepositoryImpl implements IRepository {

    RealmConfiguration realmConfig;
    Realm realm;

    public RepositoryImpl(RealmConfiguration realmConfig, Realm realm) {
        this.realmConfig = realmConfig;
        this.realm = realm;
    }

    @NotNull
    @Override
    public Observable<TextData> createTextData(@NotNull final TextData data) {

        Observable<TextData> observable = Observable.create(

                new Observable.OnSubscribe<TextData>() {

                    @Override
                    public void call(final Subscriber<? super TextData> subscriber) {

                        realm.executeTransaction(new Realm.Transaction() {

                            @Override
                            public void execute(Realm bgRealm) {

                                realm.beginTransaction();
                                realm.copyToRealm(data);
                                realm.commitTransaction();

                                subscriber.onNext(data);
                                subscriber.onCompleted();

                            }
                        });
                    }

                });

        observable.subscribeOn(Schedulers.io());
        observable.observeOn(AndroidSchedulers.mainThread());
        observable.subscribe();
        return observable;
    }

    @NotNull
    @Override
    public Observable<List<TextData>> readTextData(final boolean errored) {

        Observable<List<TextData>> observable = Observable.create(

                new Observable.OnSubscribe<List<TextData>>() {

                    @Override
                    public void call(final Subscriber<? super List<TextData>> subscriber) {

                        realm.executeTransaction(new Realm.Transaction() {

                            @Override
                            public void execute(Realm bgRealm) {

                                String errorValue = Enum.callBackResult.ERROR.name();
                                String columnName = "result";
                                RealmResults<TextData> result = bgRealm
                                        .where(TextData.class).equalTo(columnName, errorValue).findAll();

                                subscriber.onNext(result);
                                subscriber.onCompleted();

                            }
                        });
                    }

                });

        observable.subscribeOn(Schedulers.io());
        observable.observeOn(AndroidSchedulers.mainThread());
        observable.subscribe();
        return observable;
    }

    @NotNull
    @Override
    public Observable<List<NumData>> readNumData(boolean errored) {
        return null;
    }


    @NotNull
    @Override
    public Observable<NumData> createNumData(@NotNull NumData data) {
        return null;
    }
}
