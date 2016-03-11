package com.parsable.appetizer.parasable;
import android.os.Build;
import com.parsable.appetizer.parasable.Model.ApiJsonPojo.AuthToken;
import com.parsable.appetizer.parasable.Model.ApiJsonPojo.CreatApiPojo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import java.util.List;
import com.parsable.appetizer.parasable.Model.ApiJsonPojo.LogOutApiPojo;
import com.parsable.appetizer.parasable.Model.ApiJsonPojo.LoginApiPojo;
import com.parsable.appetizer.parasable.Model.ApiJsonPojo.SendNumberApiPojo;
import com.parsable.appetizer.parasable.Model.ApiJsonPojo.SendTextApiPojo;
import com.parsable.appetizer.parasable.Util.StringHelper;
import com.parsable.appetizer.parasable.Network.*;
import okhttp3.ResponseBody;
import rx.Observable;
import rx.observers.TestSubscriber;

/**
 * Created by Davix on 3/9/16.
 */

@RunWith(RobolectricTestRunner.class)
@Config(sdk = Build.VERSION_CODES.LOLLIPOP , manifest = "src/main/AndroidManifest.xml")
//@PrepareForTest({Request.class ,Request.Builder.class })
public class WebApiServiceUnitTest {

    IWebApiService service;

    String email = "";
    String loginEmail = "david@parsable.com";
    String password = "parsable";

    @Before
    public void setUp(){

        this.email = new StringHelper().generateEmail();
        this.service = buildWebApiService(null);

    }

    @Test
    public void createAccountTest(){

        //1)Create Json From Pojo
        CreatApiPojo creatApiPojo = new CreatApiPojo();
        creatApiPojo.setEmail(this.email);
        creatApiPojo.setPassword(this.password);

        //2)Make a Call to the server
        Observable<ResponseBody> observable = this.service.createAccount(creatApiPojo);
        TestSubscriber<ResponseBody> subscriber = new TestSubscriber<ResponseBody>();
        observable.subscribe(subscriber);

        //3)Assert no errors
        subscriber.assertCompleted();
        subscriber.assertNoErrors();

        //4)Assert response
        ResponseBody response =subscriber.getOnNextEvents().get(0);
        assert(response !=null);

    }

    @Test
    public void loginAccountTest(){

        //Login
        LoginApiPojo loginApiPojo = new LoginApiPojo();
        loginApiPojo.setEmail(this.loginEmail);
        loginApiPojo.setPassword(this.password);
        Observable<AuthToken> observable = this.service.loginAccount(loginApiPojo);

        TestSubscriber<AuthToken> subscriber = new TestSubscriber<AuthToken>();
        observable.subscribe(subscriber);
        subscriber.assertNoErrors();
        List<AuthToken> listOfresponse = subscriber.getOnNextEvents();

        //Assertions
        assert (listOfresponse != null);
        assert (listOfresponse.get(0)!=null);

        AuthToken token = listOfresponse.get(0);
        assert (token.AuthToken.isEmpty() != true);

    }

    @Test
    public void logoutAccountTest(){

        //Testing Algorithm
        //1)Log In (No assert, assume it works)
        //Login
        LoginApiPojo loginApiPojo = new LoginApiPojo();
        loginApiPojo.setEmail(this.loginEmail);
        loginApiPojo.setPassword(this.password);

        Observable<AuthToken> observable = this.service.loginAccount(loginApiPojo);
        TestSubscriber<AuthToken> subscriber = new TestSubscriber<AuthToken>();
        observable.subscribe(subscriber);

        //2)Get Token
        List<AuthToken> listOfAuthTokens = subscriber.getOnNextEvents();
        AuthToken token = listOfAuthTokens.get(0);

        //3))Rebuild service with retrofit
        this.service = buildWebApiService(token);

        //4)Log Out
        LogOutApiPojo logOutApiPojo = new LogOutApiPojo();
        Observable<ResponseBody> logOutObserver = this.service.logoutAccount(logOutApiPojo);
        TestSubscriber<ResponseBody> logOutsubscriber = new TestSubscriber<ResponseBody>();
        logOutObserver.subscribe(logOutsubscriber);

        //5)Assert Subscriber
        logOutsubscriber.onCompleted();
        logOutsubscriber.assertNoErrors();

        assert (logOutsubscriber.getOnNextEvents().get(0)!= null);
    }

    @Test
    public void sendTextTest(){

        //Testing Algorithm
        //1)Log In (No assert, assume it works)
        //Login
        LoginApiPojo loginApiPojo = new LoginApiPojo();
        loginApiPojo.setEmail(this.loginEmail);
        loginApiPojo.setPassword(this.password);

        Observable<AuthToken> observable = this.service.loginAccount(loginApiPojo);
        TestSubscriber<AuthToken> subscriber = new TestSubscriber<AuthToken>();
        observable.subscribe(subscriber);

        //2)Get Token
        List<AuthToken> listOfAuthTokens = subscriber.getOnNextEvents();
        AuthToken token = listOfAuthTokens.get(0);

        //3))Rebuild service with retrofit
        this.service = buildWebApiService(token);

        //4)SendText
        SendTextApiPojo sendTextApiPojo = new SendTextApiPojo("Hello World");
        Observable<ResponseBody> sendTextObserver = this.service.sendText(sendTextApiPojo);
        TestSubscriber<ResponseBody> sendTextsubscriber = new TestSubscriber<ResponseBody>();
        sendTextObserver.subscribe(sendTextsubscriber);

        //5)Assert Subscriber
        sendTextsubscriber.assertCompleted();
        sendTextsubscriber.assertNoErrors();

        List<ResponseBody> listOfresponse = sendTextsubscriber.getOnNextEvents();
        assert (listOfresponse != null);
        assert (listOfresponse.get(0)!=null);
    }

    @Test
    public void sendNumTest(){


        //Testing Algorithm
        //1)Log In (No assert, assume it works)
        //Login
        LoginApiPojo loginApiPojo = new LoginApiPojo();
        loginApiPojo.setEmail(this.loginEmail);
        loginApiPojo.setPassword(this.password);

        Observable<AuthToken> observable = this.service.loginAccount(loginApiPojo);
        TestSubscriber<AuthToken> subscriber = new TestSubscriber<AuthToken>();
        observable.subscribe(subscriber);

        //2)Get Token
        List<AuthToken> listOfAuthTokens = subscriber.getOnNextEvents();
        AuthToken token = listOfAuthTokens.get(0);

        //3))Rebuild service with retrofit
        this.service = buildWebApiService(token);

        //4)SendNumber
        SendNumberApiPojo sendNumberApiPojo = new SendNumberApiPojo("1.0");
        Observable<ResponseBody> sendNumberObserver = this.service.sendNumber(sendNumberApiPojo);
        TestSubscriber<ResponseBody> sendNumbersubscriber = new TestSubscriber<ResponseBody>();
        sendNumberObserver.subscribe(sendNumbersubscriber);

        //5)Assert Subscriber
        sendNumbersubscriber.assertNoErrors();
        sendNumbersubscriber.assertCompleted();

        List<ResponseBody> listOfresponse = sendNumbersubscriber.getOnNextEvents();
        assert (listOfresponse != null);
        assert (listOfresponse.get(0)!=null);

    }

    private IWebApiService buildWebApiService(AuthToken token){

        return new RetrofitHelper().buildWebApiService(token);

    }
}
