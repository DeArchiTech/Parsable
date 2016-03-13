package com.parsable.appetizer.parasable;

import android.app.Instrumentation;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.parsable.appetizer.parasable.Event.LoginEvent;
import com.parsable.appetizer.parasable.Model.ApiJsonPojo.AuthToken;
import com.parsable.appetizer.parasable.Presenter.ISendDataPresenter;
import com.parsable.appetizer.parasable.Presenter.SendDataPresenterImpl;
import com.parsable.appetizer.parasable.Repository.IRepository;
import com.parsable.appetizer.parasable.Repository.RepositoryImpl;
import com.parsable.appetizer.parasable.Subscriber.AutoLoginSubscriber;
import com.parsable.appetizer.parasable.Util.NumberHelper;
import com.parsable.appetizer.parasable.Util.StringHelper;
import com.parsable.appetizer.parasable.View.SendDataActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import rx.Observable;
import rx.observers.TestSubscriber;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.*;

/**
 * Created by Davix on 3/11/16.
 */
@RunWith(AndroidJUnit4.class)
public class SendDataActivityUITest {

    @Rule
    public final ActivityTestRule<SendDataActivity> sendData = new ActivityTestRule<SendDataActivity>(SendDataActivity.class);

    ISendDataPresenter presenter;
    IRepository repository;
    @Before
    public void setUp(){

        repository = new RepositoryImpl();
        presenter = new SendDataPresenterImpl(repository);
        sendData.getActivity().setPresnter(presenter);

    }

    @Test
    public void testUIElements(){

        //1)Assert there is an input box
        onView(withId(R.id.sendDataEditText))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));

        //2)Assert there is an input box
        onView(withId(R.id.sendDatabutton))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

    @Test
    public void autoLoginAndSendTextTest() throws InterruptedException{

        //1)Auto Login Repository
        presenter.autoLoginEvent(new AutoLoginSubscriber<AuthToken>(sendData.getActivity()));

        //Need some type of auto login mechanism for this to really work
        //Wait until user is logged in
        Thread.sleep(2000);

        onView(withId(android.R.id.button1))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));

        onView(withId(android.R.id.button1)).perform(ViewActions.click());

        //1)Insert Text into textBox
        onView(withId(R.id.sendDataEditText))
                .perform(ViewActions.typeText(new StringHelper().generateText()));

        Espresso.closeSoftKeyboard();


        //2)Click button
        onView(withId(R.id.sendDatabutton))
                .perform(ViewActions.click());

        //4)Assert Success
        Thread.sleep(2000);

        //5)CLose Dialog box
        onView(withId(android.R.id.button1)).perform(ViewActions.click());

    }

    @Test
    public void autoLoginAndSendNumberTest() throws InterruptedException{

        //1)Auto Login Repository
        presenter.autoLoginEvent(new AutoLoginSubscriber<AuthToken>(sendData.getActivity()));

        //Need some type of auto login mechanism for this to really work
        //Wait until user is logged in
        Thread.sleep(2000);

        onView(withId(android.R.id.button1))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));

        onView(withId(android.R.id.button1)).perform(ViewActions.click());

        //1)Insert Text into textBox
        onView(withId(R.id.sendDataEditText))
                .perform(ViewActions.typeText(new NumberHelper().generateNumberInString()));

        Espresso.closeSoftKeyboard();


        //2)Click button
        onView(withId(R.id.sendDatabutton))
                .perform(ViewActions.click());

        //4)Wait for Success
        Thread.sleep(2000);

        //2)Assert there is an input box Success String on it
        String success = sendData.getActivity().getResources().getString(R.string.displaySuccessButton);

        onView(withText(success))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));

        //5)CLose Dialog box
        onView(withId(android.R.id.button1)).perform(ViewActions.click());

    }

}
