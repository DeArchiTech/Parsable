package com.parsable.appetizer.parasable.RealmTest;

import android.content.Context;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.parsable.appetizer.parasable.Model.User;
import com.parsable.appetizer.parasable.Repository.CacheData;
import com.parsable.appetizer.parasable.Repository.IUserData;
import com.parsable.appetizer.parasable.View.LoginActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;
import rx.Observable;
import rx.observers.TestSubscriber;

/**
 * Created by Davix on 3/13/16.
 */
@RunWith(AndroidJUnit4.class)
public class UserCRUDDataStoreUnitTest {

    IUserData dataStore;
    Realm realm;

    @Rule
    public final ActivityTestRule<LoginActivity> login = new ActivityTestRule<>(LoginActivity.class);

    @Before
    public void setUp() {

        Context context = login.getActivity().getBaseContext();
        RealmConfiguration realmConfig = new RealmConfiguration.Builder(context)
                .name("userCrudTest.realm")
                .build();

        UserCRUDDataStoreUnitTest.this.realm = Realm.getInstance(realmConfig);
        UserCRUDDataStoreUnitTest.this.dataStore = new CacheData(realmConfig, realm);

    }

    @Test
    public void testCreate(){

        //1)Create User Data
        String token = UUID.randomUUID().toString();
        User user = new User(token);
        Observable<User> observable = this.dataStore.createUserData(user);
        TestSubscriber<User> subscriber = new TestSubscriber<User>();
        observable.subscribe(subscriber);
        subscriber.assertNoErrors();
        subscriber.assertCompleted();
        assert ( subscriber.getOnNextEvents().get(0) !=null);

    }

    @Test
    public void readTest(){

        readAlgorithm();

    }

    private void readAlgorithm(){

        //Assume Create Works
        String token = UUID.randomUUID().toString();
        User user = new User(token);

        //Create
        Observable<User> observable = this.dataStore.createUserData(user);
        TestSubscriber<User> subscriber = new TestSubscriber<User>();
        observable.subscribe(subscriber);
        subscriber.assertNoErrors();
        subscriber.assertCompleted();
        assert ( subscriber.getOnNextEvents().get(0) !=null);

        //1)Test Read
        Observable<RealmResults<User>> readObservable = this.dataStore.readUserData();
        TestSubscriber<RealmResults<User>> readSubscriber = new TestSubscriber<RealmResults<User>>();
        readObservable.subscribe(readSubscriber);
        readSubscriber.assertNoErrors();
        readSubscriber.assertCompleted();

        //2)Get Read Result
        RealmResults<User> result = readSubscriber.getOnNextEvents().get(0);
        assert (result != null) ;

        //3)Make sure UUID is in the result
        boolean tokenInLoop = false;

        for(User loopUser: result){

            tokenInLoop = loopUser.getToken().equals(token);
            if(tokenInLoop)
                break;

        }

        //4)Assert Read Token is the same as create token
        assert( tokenInLoop);

    }



}