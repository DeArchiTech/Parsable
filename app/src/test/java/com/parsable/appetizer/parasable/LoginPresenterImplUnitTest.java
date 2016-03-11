package com.parsable.appetizer.parasable;

import android.os.Build;

import com.parsable.appetizer.parasable.Event.CreateAccountEvent;
import com.parsable.appetizer.parasable.Event.LoginEvent;
import com.parsable.appetizer.parasable.Model.ApiJsonPojo.AuthToken;
import com.parsable.appetizer.parasable.Presenter.ILoginPresenter;
import com.parsable.appetizer.parasable.Presenter.LoginPresenterImpl;
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
@Config(sdk = Build.VERSION_CODES.LOLLIPOP , manifest = "src/main/AndroidManifest.xml")
@RunWith(RobolectricTestRunner.class)
public class LoginPresenterImplUnitTest {

    ILoginPresenter presenter;
    IRepository repository;
    String email;
    String password;
    String loginEmail;

    @Before
    public void setUp(){

        this.repository = new RepositoryImpl(new MockWebApiService());
        this.presenter = new LoginPresenterImpl(repository);
        this.email = new StringHelper().generateEmail();
        this.loginEmail = new StringHelper().generateLoginEmail();
        this.password = new StringHelper().generatePassword();
    }

    @Test
    public void logoutActionTest(){

        //1)Get Observable and subscriber
        Observable<ResponseBody> observable = this.presenter.logOutAction();
        TestSubscriber<ResponseBody> subscriber = new TestSubscriber<ResponseBody>();
        observable.subscribe(subscriber);

        //2)Assert Subscriber
        subscriber.assertCompleted();
        subscriber.assertNoErrors();
        assert( null != subscriber.getOnNextEvents().get(0));

    }

    @Test
    public void loginActionTest(){

        //1)Mock Login Event
        LoginEvent event = new LoginEvent(this.loginEmail, this.password);

        //2)Get Observable and subscriber
        Observable<AuthToken> observable = this.presenter.loginAction(event);
        TestSubscriber<AuthToken> subscriber = new TestSubscriber<AuthToken>();
        observable.subscribe(subscriber);

        //3)Assert Subscriber
        subscriber.assertCompleted();
        subscriber.assertNoErrors();
        assert( null != subscriber.getOnNextEvents().get(0));
    }

    @Test
    public void signUpActionTest(){

        //1)Mock SignUp Event
        CreateAccountEvent event = new CreateAccountEvent(this.email, this.password);

        //2)Get Observable and subscriber
        Observable<ResponseBody> observable = this.presenter.createAccountAction(event);
        TestSubscriber<ResponseBody> subscriber = new TestSubscriber<ResponseBody>();
        observable.subscribe(subscriber);

        //3)Assert Subscriber
        subscriber.assertCompleted();
        subscriber.assertNoErrors();
        assert( null != subscriber.getOnNextEvents().get(0));

    }

}
