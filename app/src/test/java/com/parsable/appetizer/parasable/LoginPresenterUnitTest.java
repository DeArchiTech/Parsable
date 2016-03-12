package com.parsable.appetizer.parasable;

import android.os.Build;

import com.parsable.appetizer.parasable.Event.CreateAccountEvent;
import com.parsable.appetizer.parasable.Event.LoginEvent;
import com.parsable.appetizer.parasable.Model.ApiJsonPojo.AuthToken;
import com.parsable.appetizer.parasable.Network.RetrofitHelper;
import com.parsable.appetizer.parasable.Subscriber.CreateAccountSubscriber;
import com.parsable.appetizer.parasable.Subscriber.LogOutSubscriber;
import com.parsable.appetizer.parasable.Subscriber.LoginSubscriber;
import com.parsable.appetizer.parasable.Util.StringHelper;
import com.parsable.appetizer.parasable.Presenter.ILoginPresenter;
import com.parsable.appetizer.parasable.Presenter.LoginPresenterImpl;
import com.parsable.appetizer.parasable.Repository.IRepository;
import com.parsable.appetizer.parasable.Repository.RepositoryImpl;
import com.parsable.appetizer.parasable.View.ILoginView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import okhttp3.ResponseBody;
import rx.Subscriber;

/**
 * Created by Davix on 3/10/16.
 */

@Config(sdk = Build.VERSION_CODES.LOLLIPOP , manifest = "src/main/AndroidManifest.xml")
@RunWith(RobolectricTestRunner.class)
public class LoginPresenterUnitTest {

    ILoginPresenter presenter;
    IRepository repository;
    ILoginView view;
    String email;
    String password;
    String loginEmail;

    @Before
    public void setUp(){

        this.view = new MockLoginView();
        this.repository = new RepositoryImpl(new RetrofitHelper().buildWebApiService());
        this.presenter = new LoginPresenterImpl(this.repository);
        this.email = new StringHelper().generateEmail();
        this.loginEmail = new StringHelper().createLoginEmail();
        this.password = new StringHelper().createLoginPassword();
    }

    @Test
    public void logoutActionTest(){

        //1)Get Observable and subscriber
        this.presenter.logOutAction(new LogOutSubscriber<ResponseBody>(this.view));
        //Todo Write Logic To Test Subscribers
    }

    @Test
    public void loginActionTest(){

        //1)Get Observable and subscriber
        LoginEvent event = new LoginEvent(this.email , this.password);
        this.presenter.loginAction(event, new LoginSubscriber<AuthToken>(this.view));
    }

    @Test
    public void signUpActionTest(){

        //1)Get Observable and subscriber
        CreateAccountEvent event = new CreateAccountEvent(this.email , this.password);
        this.presenter.createAccountAction(event,new CreateAccountSubscriber<ResponseBody>(this.view));

    }

}
