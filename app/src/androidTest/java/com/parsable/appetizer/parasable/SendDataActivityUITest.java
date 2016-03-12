package com.parsable.appetizer.parasable;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.parsable.appetizer.parasable.Model.ApiJsonPojo.AuthToken;
import com.parsable.appetizer.parasable.Presenter.ISendDataPresenter;
import com.parsable.appetizer.parasable.Presenter.SendDataPresenterImpl;
import com.parsable.appetizer.parasable.Repository.IRepository;
import com.parsable.appetizer.parasable.Repository.RepositoryImpl;
import com.parsable.appetizer.parasable.Subscriber.AutoLoginSubscriber;
import com.parsable.appetizer.parasable.Util.StringHelper;
import com.parsable.appetizer.parasable.View.SendDataActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.*;

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
        repository.blockingAutoLogin(new AutoLoginSubscriber<AuthToken>(repository));
        ISendDataPresenter presenter = new SendDataPresenterImpl(repository);
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
    public void sendNumberTest() throws InterruptedException{

        //1)Insert Text into textBox
        String inputText = new StringHelper().generateNumber();

        onView(withId(R.id.sendDataEditText))
                .perform(ViewActions.typeText(inputText));

        Espresso.closeSoftKeyboard();

        //2)Click button
        onView(withId(R.id.sendDatabutton))
                .perform(ViewActions.click());

        Thread.sleep(3000);

        //4)Click dialog
        onView(withId(android.R.id.button1)).perform(ViewActions.click());
    }

    @Test
    public void sendTextTest(){

        //1)Insert Text into textBox
        onView(withId(R.id.sendDataEditText))
                .perform(ViewActions.typeText(new StringHelper().generateText()));

        //2)Click button
        onView(withId(R.id.sendDatabutton))
                .perform(ViewActions.click());

        //3)Assert Correct Result

        //4)Click dialog
        onView(withId(android.R.id.button1)).perform(ViewActions.click());
    }

}
