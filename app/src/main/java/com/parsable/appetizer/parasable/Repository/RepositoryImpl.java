package com.parsable.appetizer.parasable.Repository;

import com.parsable.appetizer.parasable.ParsableEnum;
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

                        realm.beginTransaction();
                        realm.copyToRealm(data);
                        realm.commitTransaction();

                        subscriber.onNext(data);
                        subscriber.onCompleted();
                    }

                });

        observable.subscribeOn(Schedulers.io());
        observable.observeOn(AndroidSchedulers.mainThread());
        observable.subscribe();
        return observable;

    }

    @NotNull
    @Override
    public Observable<RealmResults<TextData>> readTextData(@NotNull ParsableEnum.callBackResult result) {

        String errorValue = result.name();
        String columnName = "result";

        return realm
                .where(TextData.class)
                .equalTo(columnName, errorValue)
                .findAllAsync()
                .asObservable();

    }

    @NotNull
    @Override
    public Observable<NumData> createNumData(@NotNull final NumData data) {

        Observable<NumData> observable = Observable.create(

                new Observable.OnSubscribe<NumData>() {

                    @Override
                    public void call(final Subscriber<? super NumData> subscriber) {

                        realm.beginTransaction();
                        realm.copyToRealm(data);
                        realm.commitTransaction();

                        subscriber.onNext(data);
                        subscriber.onCompleted();
                    }

                });

        observable.subscribeOn(Schedulers.io());
        observable.observeOn(AndroidSchedulers.mainThread());
        observable.subscribe();
        return observable;

    }

    @NotNull
    @Override
    public Observable<RealmResults<NumData>> readNumData(@NotNull ParsableEnum.callBackResult result) {

        String errorValue = result.name();
        String columnName = "result";

        return realm
                .where(NumData.class)
                .equalTo(columnName, errorValue)
                .findAllAsync()
                .asObservable();
    }


}
