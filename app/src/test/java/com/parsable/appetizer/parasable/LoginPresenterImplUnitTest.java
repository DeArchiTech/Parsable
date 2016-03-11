package com.parsable.appetizer.parasable;

import android.os.Build;

import com.parsable.appetizer.parasable.Event.CreateAccountEvent;
import com.parsable.appetizer.parasable.Event.LoginEvent;
import com.parsable.appetizer.parasable.Model.ApiJsonPojo.AuthToken;
import com.parsable.appetizer.parasable.Presenter.ILoginPresenter;
import com.parsable.appetizer.parasable.Presenter.LoginPresenterImpl;
import com.parsable.appetizer.parasable.Presenter.LoginSubscriber;
import com.parsable.appetizer.parasable.Repository.IRepository;
import com.parsable.appetizer.parasable.Repository.RepositoryImpl;
import com.parsable.appetizer.parasable.View.ILoginView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import okhttp3.ResponseBody;
import rx.Observable;
import rx.Subscriber;
import rx.observers.TestSubscriber;

/**
 * Created by Davix on 3/10/16.
 */
@Config(sdk = Build.VERSION_CODES.LOLLIPOP , manifest = "src/main/AndroidManifest.xml")
@RunWith(RobolectricTestRunner.class)
public class LoginPresenterImplUnitTest {

    ILoginPresenter presenter;
    IRepository repository;
    ILoginView view;
    String email;
    String password;
    String loginEmail;

    @Before
    public void setUp(){

        this.view = new MockLoginView();
        this.repository = new RepositoryImpl(new MockWebApiService());
        this.presenter = new LoginPresenterImpl(this.repository, this.view);
        this.email = new StringHelper().generateEmail();
        this.loginEmail = new StringHelper().generateLoginEmail();
        this.password = new StringHelper().generatePassword();
    }

    @Test
    public void logoutActionTest(){

        //1)Get Observable and subscriber
        Subscriber<ResponseBody> subscriber = this.presenter.logOutAction();
        assert (subscriber!=null);
        //Todo Write Logic To Test Subscribers
    }

    @Test
    public void loginActionTest(){

        //1)Get Observable and subscriber
        LoginEvent event = new LoginEvent(this.email , this.password);
        Subscriber<AuthToken> subscriber = this.presenter.loginAction(event);
        assert (subscriber!=null);
    }

    @Test
    public void signUpActionTest(){

        //1)Get Observable and subscriber
        CreateAccountEvent event = new CreateAccountEvent(this.email , this.password);
        Subscriber<ResponseBody> subscriber = this.presenter.createAccountAction(event);
        assert (subscriber!=null);

    }

}
