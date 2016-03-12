package com.parsable.appetizer.parasable;

import com.parsable.appetizer.parasable.Event.CreateAccountEvent;
import com.parsable.appetizer.parasable.Event.LoginEvent;
import com.parsable.appetizer.parasable.Model.ApiJsonPojo.AuthToken;
import com.parsable.appetizer.parasable.Repository.IRepository;
import com.parsable.appetizer.parasable.Repository.RepositoryImpl;
import com.parsable.appetizer.parasable.Subscriber.AutoLoginSubscriber;
import com.parsable.appetizer.parasable.Util.NumberHelper;
import com.parsable.appetizer.parasable.Util.StringHelper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import okhttp3.ResponseBody;
import rx.Observable;
import rx.observers.TestSubscriber;

/**
 * Created by Davix on 3/10/16.
 */
@RunWith(RobolectricTestRunner.class)
public class RepositoryUnitTest {

    IRepository repository;
    String createAccntemail ="";
    String loginEmail ="";
    String password = "";
    @Before
    public void setUp(){

        this.repository = new RepositoryImpl();
        this.createAccntemail = new StringHelper().generateEmail();
        this.loginEmail = new StringHelper().createLoginEmail();
        this.password = new StringHelper().createLoginPassword();

    }

    @Test
    public void createActionActionTest(){

        //1)Mock Event
        CreateAccountEvent event = new CreateAccountEvent(this.createAccntemail, this.password);

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

        //1)Mock Event
        LoginEvent event = new LoginEvent(this.loginEmail, this.password);

        //2)Get Observables
        Observable<AuthToken> observable = repository.loginAction(event);
        TestSubscriber<AuthToken> subscriber = new TestSubscriber<>();
        observable.subscribe(subscriber);

        //3)Assert Subscriber
        subscriber.assertCompleted();
        subscriber.assertNoErrors();
        assert (subscriber.getOnNextEvents().get(0) != null);

        //4)Test Able to perform logged in functions
        Observable<ResponseBody> secondObservable = this.repository.sendText("hello");
        TestSubscriber<ResponseBody> secondSubscriber = new TestSubscriber<>();
        secondObservable.subscribe(secondSubscriber);

        //5)Assert subscriber
        secondSubscriber.assertCompleted();
        secondSubscriber.assertNoErrors();
        assert (secondSubscriber.getOnNextEvents().get(0) != null);

    }

    @Test
    public void logOutActionTest(){

        //1)Get Observables by calling service
        Observable<ResponseBody> observable = this.repository.logOut();
        TestSubscriber<ResponseBody> subscriber = new TestSubscriber<>();
        observable.subscribe(subscriber);

        //2)Assert subscriber
        subscriber.assertCompleted();
        subscriber.assertNoErrors();
        assert (subscriber.getOnNextEvents().get(0) != null);

    }

    @Test
    public void sendTextActionTest(){

        //1)Get observable and subscriber
        Observable<ResponseBody> observable = this.repository.sendText("hello");
        TestSubscriber<ResponseBody> subscriber = new TestSubscriber<>();
        observable.subscribe(subscriber);

        //2)Assert subscriber
        subscriber.assertCompleted();
        subscriber.assertNoErrors();
        assert (subscriber.getOnNextEvents().get(0) != null);
    }

    @Test
    public void sendNumberActionTest(){

        //1)Auto Login
        AutoLoginSubscriber<AuthToken> subscriber = new AutoLoginSubscriber<>(this.repository);
        this.repository.blockingAutoLogin(subscriber);

        //2)Get observable and subscriber
        Observable<ResponseBody> observable = this.repository.sendNumber(new NumberHelper().generateNumberInString());
        TestSubscriber<ResponseBody> testSubscriber = new TestSubscriber<ResponseBody>();
        observable.subscribe(testSubscriber);

        //3)Assert subscriber
        testSubscriber.assertCompleted();
        testSubscriber.assertNoErrors();
        assert (testSubscriber.getOnNextEvents().get(0) != null);

    }

    @Test
    public void autoLoginTest(){

        //1)Get Observable and subscriber
        AutoLoginSubscriber<AuthToken> subscriber = new AutoLoginSubscriber<>(this.repository);
        this.repository.blockingAutoLogin(subscriber);

        //wait for subscriber to get resource
        assert(subscriber.getToken() !=null );

    }
}
