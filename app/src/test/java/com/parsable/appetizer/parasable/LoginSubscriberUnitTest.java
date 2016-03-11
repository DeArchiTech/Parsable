package com.parsable.appetizer.parasable;
import com.parsable.appetizer.parasable.Presenter.LoginSubscriber;
import com.parsable.appetizer.parasable.View.ILoginView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import okhttp3.MediaType;
import okhttp3.ResponseBody;

/**
 * Created by Davix on 3/10/16.
 */
@RunWith(RobolectricTestRunner.class)
public class LoginSubscriberUnitTest {

    LoginSubscriber<ResponseBody> subscriber;
    ILoginView view;

    @Before
    public void setUp(){
        this.view = new MockLoginView();
        this.subscriber = new LoginSubscriber<ResponseBody>(this.view , ParsableEnum.actionName.Login);
    }

    @Test
    public void onErrorTest(){

        this.subscriber.onError(new Throwable());
    }

    @Test
    public void onNextTest(){

        this.subscriber.onNext(ResponseBody.create(MediaType.parse(""),""));

    }
}
