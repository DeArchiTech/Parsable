package com.parsable.appetizer.parasable;

import android.app.Application;
import android.content.Context;
import android.support.test.runner.AndroidJUnit4;
import com.parsable.appetizer.parasable.Model.TextData;
import com.parsable.appetizer.parasable.Repository.IRepository;
import com.parsable.appetizer.parasable.Repository.RepositoryImpl;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import java.util.Arrays;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import rx.Observable;
import rx.observers.TestSubscriber;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */

//Note: Can't run this with unit test
//Need to run this with instrumental test
@RunWith(AndroidJUnit4.class)
public class RepositoryImplUnitTest extends TestCase{

    IRepository repository;

    @Before
    public void setUp(){

        Context context = new Application();
        RealmConfiguration realmConfig = new RealmConfiguration.Builder(context).build();
        Realm realm = Realm.getInstance(realmConfig);
        this.repository = new RepositoryImpl(realmConfig, realm);

    }

    @Test
    public void testCreateTextData(){

        //Test Algorithm
        //1)Create Object
        TextData data = new TextData();
        data.setData("testData");
        data.setResult(Enum.callBackResult.ERROR.name());
        //2)Save Object To Realm
        Observable<TextData> observable = this.repository.createTextData(data);
        //3)Assert
        TestSubscriber<TextData> subscriber = new TestSubscriber<TextData>();
        subscriber.assertCompleted();
        subscriber.assertNoErrors();
        subscriber.assertReceivedOnNext(Arrays.asList(data));
        observable.subscribe(subscriber);

    }

    @Test
    public void testGetAndSaveNumtData(){

        //Test Algorithm
        //1)Create Object
        //2)Save Object To Realm
        //3)Read Object From Realm
        //4)Close Connection
        assert (false);

    }

}