package com.parsable.appetizer.parasable;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
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
        Context context = InstrumentationRegistry.getTargetContext();
        RealmConfiguration realmConfig = new RealmConfiguration.Builder(context)
                .name("myrealm.realm")
                .inMemory()
                .build();

        this.realm = Realm.getInstance(realmConfig);
        this.repository = new RepositoryImpl(realmConfig, realm);

    }

    @Test
    public void testCreateTextData(){

        //Test Algorithm
        //1)Create Object
        TextData data = new TextData();
        data.setData("testData");
        data.setResult(ParsableEnum.callBackResult.ERROR.name());
        //2)Save Object To Realm
        Observable<TextData> observable = this.repository.createTextData(data);
        //3)Assert
        TestSubscriber<TextData> subscriber = new TestSubscriber<TextData>();
        observable.subscribe(subscriber);

        subscriber.assertCompleted();
        subscriber.assertNoErrors();
        subscriber.assertReceivedOnNext(Arrays.asList(data));

    }

    @Test
    public void testReadTextData(){

        //Test Algorithm
        //1)Create Object
        this.realm.beginTransaction();
        TextData data = this.realm.createObject(TextData.class);
        data.setData(UUID.randomUUID().toString());
        data.setResult(ParsableEnum.callBackResult.ERROR.name());

        //2)Save object To realm
        this.realm.commitTransaction();

        //3)Retrieve object from realm
        Observable<RealmResults<TextData>> observable = this.repository.readTextData(false);

        //4)Assert Observable holds the same object
        assert (false);

    }

    @Test
    public void testCreateNumdata(){

        //Test Algorithm
        //1)Create Object
        //2)Save Object To Realm
        //3)Read Object From Realm
        //4)Close Connection
        assert (false);

    }

    @Test
    public void testReadNumdata(){

        assert (false);

    }

}