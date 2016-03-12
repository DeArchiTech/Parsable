package com.parsable.appetizer.parasable;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.parsable.appetizer.parasable.Model.ApiJsonPojo.AuthToken;
import com.parsable.appetizer.parasable.Presenter.ISendDataPresenter;
import com.parsable.appetizer.parasable.Presenter.SendDataPresenterImpl;
import com.parsable.appetizer.parasable.Repository.IRepository;
import com.parsable.appetizer.parasable.Repository.RepositoryImpl;
import com.parsable.appetizer.parasable.Subscriber.AutoLoginSubscriber;
import com.parsable.appetizer.parasable.View.SendDataActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by Davix on 3/11/16.
 */
@RunWith(AndroidJUnit4.class)
public class SendDataActivityUITest {

    @Rule
    public final ActivityTestRule<SendDataActivity> sendData = new ActivityTestRule<SendDataActivity>(SendDataActivity.class);

    @Before
    public void setUp(){

        //Trigger Repository To Already Be Logged In
        //This is more of an automated test than a simple UI test
        IRepository repository = new RepositoryImpl();
        repository.autoLogin(new AutoLoginSubscriber<AuthToken>(repository));
        ISendDataPresenter presenter = new SendDataPresenterImpl(repository);
        sendData.getActivity().setPresnter(presenter);

    }

    @Test
    public void testUIElements(){

        //1)Assert there is an input box
        //2)Assert there is a button

    }

    @Test
    public void sendNumberTest(){

        //1)Type in Number into box
        //2)Click button
        //3)Assert Correct Result
    }

    @Test
    public void sendTextTest(){

        //1)Type in Text into box
        //2)Click button
        //3)Assert Correct Result
    }

}
