package com.parsable.appetizer.parasable;

import com.parsable.appetizer.parasable.Event.CreateAccountEvent;
import com.parsable.appetizer.parasable.Network.IWebApiService;
import com.parsable.appetizer.parasable.Repository.IRepository;
import com.parsable.appetizer.parasable.Repository.RepositoryImpl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import okhttp3.ResponseBody;
import rx.Observable;
import rx.observers.TestSubscriber;

/**
 * Created by Davix on 3/10/16.
 */
@RunWith(RobolectricTestRunner.class)
public class RepositoryUnitTest {

    IRepository repository;
    String email ="";
    String password = "";
    @Before
    public void setUp(){

        IWebApiService webApiService = new MockWebApiService();
        this.repository = new RepositoryImpl(webApiService);
        this.email = "david@david.com";
        this.password = "parsable";

    }

    @Test
    public void createActionActionTest(){

        //1)Mock Event
        CreateAccountEvent event = new CreateAccountEvent(this.email, this.password);

        //2)Get Observables
        Observable<ResponseBody> observable = repository.createAccountAction(event);
        TestSubscriber<ResponseBody> subscriber = new TestSubscriber<>();
        observable.subscribe(subscriber);

        //3)Assert Subscriber
        subscriber.assertCompleted();
        subscriber.assertNoErrors();
        assert (subscriber.getOnNextEvents().get(0) != null);

    }

    @Test
    public void loginActionTest(){

        assert(false);

    }

    @Test
    public void logOutActionTest(){

        assert(false);

    }

    @Test
    public void sendTextActionTest(){

        assert(false);

    }

    @Test
    public void sendNumberActionTest(){

        assert(false);

    }
}
