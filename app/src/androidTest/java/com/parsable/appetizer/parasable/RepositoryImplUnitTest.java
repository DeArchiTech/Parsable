package com.parsable.appetizer.parasable;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.parsable.appetizer.parasable.Model.NumData;
import com.parsable.appetizer.parasable.Model.TextData;
import com.parsable.appetizer.parasable.Repository.IRepository;
import com.parsable.appetizer.parasable.Repository.RepositoryImpl;
import com.parsable.appetizer.parasable.View.LoginActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.util.Arrays;
import java.util.UUID;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;
import rx.Observable;
import rx.observers.TestSubscriber;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */

//Note: Can't run this with unit test
//Need to run this with instrumental test
@RunWith(AndroidJUnit4.class)
public class RepositoryImplUnitTest{

    IRepository repository;
    Realm realm;

    @Rule
    public final ActivityTestRule<LoginActivity> login = new ActivityTestRule<>(LoginActivity.class);

    @Before
    public void setUp(){

        //Set UP
        InstrumentationRegistry.getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                Context context = InstrumentationRegistry.getTargetContext();
                RealmConfiguration realmConfig = new RealmConfiguration.Builder(context)
                        .name("myrealm.realm")
                        .inMemory()
                        .build();

                RepositoryImplUnitTest.this.realm = Realm.getInstance(realmConfig);
                RepositoryImplUnitTest.this.repository = new RepositoryImpl(realmConfig, realm);
            }
        });

    }

    @Test
    public void testCreateTextData(){

        //Run on the same thread that has looper
        InstrumentationRegistry.getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {

                //Test Algorithm
                //1)Create Object
                TextData data = new TextData();
                data.setData("testData");
                data.setResult(ParsableEnum.callBackResult.ERROR.name());
                //2)Save Object To Realm
                Observable<TextData> observable = RepositoryImplUnitTest.this.repository.createTextData(data);
                //3)Assert
                TestSubscriber<TextData> subscriber = new TestSubscriber<TextData>();
                observable.subscribe(subscriber);

                subscriber.assertCompleted();
                subscriber.assertNoErrors();
                subscriber.assertReceivedOnNext(Arrays.asList(data));

            }
        });

    }

    @Test
    public void testReadTextData(){

        //Run on the same thread that has looper
        InstrumentationRegistry.getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {

                //Test Algorithm
                //1)Create Object
                RepositoryImplUnitTest.this.realm.beginTransaction();
                TextData data = RepositoryImplUnitTest.this.realm.createObject(TextData.class);
                data.setData(UUID.randomUUID().toString());
                data.setResult(ParsableEnum.callBackResult.ERROR.name());

                //2)Save object To realm
                RepositoryImplUnitTest.this.realm.commitTransaction();

                //3)Retrieve object from realm
                Observable<RealmResults<TextData>> observable
                        = RepositoryImplUnitTest.this.repository.readTextData(ParsableEnum.callBackResult.ERROR);

                //4)Assert No Error
                TestSubscriber<RealmResults<TextData>> subscriber = new TestSubscriber<RealmResults<TextData>>();
                observable.subscribe(subscriber);
                subscriber.assertCompleted();
                subscriber.assertNoErrors();

                //5)Assert whats in the observable is what our desired result is supposed to be
                //TODO
            }
        });

    }

    @Test
    public void testCreateNumdata(){

        //Run on the same thread that has looper
        InstrumentationRegistry.getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {

                //Test Algorithm
                //1)Create Object
                NumData data = new NumData();
                data.setData(3);
                data.setResult(ParsableEnum.callBackResult.ERROR.name());

                //2)Save Object To Realm
                Observable<NumData> observable = RepositoryImplUnitTest.this.repository.createNumData(data);
                //3)Assert
                TestSubscriber<NumData> subscriber = new TestSubscriber<NumData>();
                observable.subscribe(subscriber);
                subscriber.assertCompleted();
                subscriber.assertNoErrors();
                subscriber.assertReceivedOnNext(Arrays.asList(data));

            }
        });
    }

    @Test
    public void testReadNumdata(){

        //Run on the same thread that has looper
        InstrumentationRegistry.getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {

                //Test Algorithm
                //1)Create Object
                RepositoryImplUnitTest.this.realm.beginTransaction();
                NumData data = RepositoryImplUnitTest.this.realm.createObject(NumData.class);
                data.setData(1.0);
                data.setResult(ParsableEnum.callBackResult.ERROR.name());

                //2)Save object To realm
                RepositoryImplUnitTest.this.realm.commitTransaction();

                //3)Retrieve object from realm
                Observable<RealmResults<NumData>> observable
                        = RepositoryImplUnitTest.this.repository.readNumData(ParsableEnum.callBackResult.ERROR);

                //4)Assert No Error
                TestSubscriber<RealmResults<NumData>> subscriber = new TestSubscriber<RealmResults<NumData>>();
                observable.subscribe(subscriber);
                subscriber.assertCompleted();
                subscriber.assertNoErrors();

                //5)Assert whats in the observable is what our desired result
                //TODO

            }
        });

    }

}