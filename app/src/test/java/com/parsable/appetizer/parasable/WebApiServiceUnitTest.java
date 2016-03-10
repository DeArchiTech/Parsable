package com.parsable.appetizer.parasable;
import android.os.Build;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.parsable.appetizer.parasable.Model.ApiJsonPojo.AuthToken;
import com.parsable.appetizer.parasable.Model.ApiJsonPojo.CreatApiPojo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import java.util.List;
import com.parsable.appetizer.parasable.Model.ApiJsonPojo.LoginApiPojo;
import com.parsable.appetizer.parasable.Network.*;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;
import rx.Observable;
import rx.observers.TestSubscriber;

/**
 * Created by Davix on 3/9/16.
 */

@RunWith(RobolectricTestRunner.class)
@Config(sdk = Build.VERSION_CODES.LOLLIPOP , manifest = "src/main/AndroidManifest.xml")
@PrepareForTest({Request.class ,Request.Builder.class })
public class WebApiServiceUnitTest {

    IWebApiService service;

    String email = "davidkwokhochan2@gmail.com";
    String loginEmail = "david@parsable.com";
    String password = "parsable";

    @Before
    public void setUp(){

        this.email = new StringHelper().generateEmail();
        this.service = buildWebApiService(null);

    }

    @Test
    public void createAccountTest(){

        CreatApiPojo creatApiPojo = new CreatApiPojo();
        creatApiPojo.setEmail(this.email);
        creatApiPojo.setPassword(this.password);

        Observable<ResponseBody> observable = this.service.createAccount(creatApiPojo);
        TestSubscriber<ResponseBody> subscriber = new TestSubscriber<ResponseBody>();

        observable.subscribe(subscriber);
        subscriber.assertNoErrors();
        List<ResponseBody> listOfresponse = subscriber.getOnNextEvents();
        assert (listOfresponse != null);
        assert (listOfresponse.get(0)!=null);

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

    }

    @Test
    public void logoutAccountTest(){

        //Testing Algorithm
        //1)Log In
        //Login
        LoginApiPojo loginApiPojo = new LoginApiPojo();
        loginApiPojo.setEmail(this.loginEmail);
        loginApiPojo.setPassword(this.password);
        Observable<AuthToken> observable = this.service.loginAccount(loginApiPojo);
        TestSubscriber<AuthToken> subscriber = new TestSubscriber<AuthToken>();
        observable.subscribe(subscriber);
        List<AuthToken> listOfresponse = subscriber.getOnNextEvents();
        AuthToken token = listOfresponse.get(0);

        //2)Rebuild service with retrofit
        this.service = buildWebApiService(token);

        //3)Log Out

    }

    @Test
    public void sendTextTest(){

        //Testing Algorithm
        //1)Log In
        //2)SendText

    }

    @Test
    public void sendNumTest(){

        //Testing Algorithm
        //1)Log In
        //2)SendNumber

    }

    private IWebApiService buildWebApiService(AuthToken token){

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new ParsableInterceptor(token))
                .addInterceptor(logging)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://54.186.152.100")
                .client(client)
                .addConverterFactory(JacksonConverterFactory.create(new ObjectMapper()))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        return retrofit.create(IWebApiService.class);
    }
}
