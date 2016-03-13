package com.parsable.appetizer.parasable.AutomatedTest;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.parsable.appetizer.parasable.R;
import com.parsable.appetizer.parasable.Util.NumberHelper;
import com.parsable.appetizer.parasable.Util.StringHelper;
import com.parsable.appetizer.parasable.View.LoginActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by Davix on 3/12/16.
 */
@RunWith(AndroidJUnit4.class)

public class SendDataAutomateTest {

    @Rule
    public final ActivityTestRule<LoginActivity> login = new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void loginAndSendTextTest() throws InterruptedException{

        inputAccountInfo();
        login();
        pushSendDataView();
        sendDataTest(new StringHelper().generateText());

    }

    @Test
    public void createAccountAndSendNumberTest() throws InterruptedException{

        generateAccountInfo();
        createAccount();
        login();
        pushSendDataView();
        sendDataTest(new NumberHelper().generateNumberInString());

    }

    @Test
    public void loginAndLogOutTest() throws InterruptedException{

        inputAccountInfo();
        login();
        logout();

    }

    private void sendDataTest(String data) throws InterruptedException{


        sendData(data);

    }

    private void inputAccountInfo() throws InterruptedException{

        //1)Input Keyboard event for email
        onView(withId(R.id.email)).perform(ViewActions.typeText(new StringHelper().createLoginEmail()));

        //2)Input Keyboard event for password
        onView(withId(R.id.password)).perform(ViewActions.typeText(new StringHelper().createLoginPassword()));
    }

    private void generateAccountInfo() throws InterruptedException{

        //1)Input Keyboard event for email
        onView(withId(R.id.email)).perform(ViewActions.typeText(new StringHelper().generateEmail()));

        //2)Input Keyboard event for password
        onView(withId(R.id.password)).perform(ViewActions.typeText(new StringHelper().createLoginPassword()));
    }

    private void createAccount() throws InterruptedException{

        //3)Press Login Button
        onView(withId(R.id.create_accnt_btn)).perform(ViewActions.click());

        //3.5)Wait
        Thread.sleep(1000);

        //4)Click dialog
        onView(withId(android.R.id.button1)).perform(ViewActions.click());

    }

    private void login() throws InterruptedException{

        //3)Press Login Button
        onView(withId(R.id.login_btn)).perform(ViewActions.click());

        //3.5)Wait
        Thread.sleep(1000);

        //4)Click dialog
        onView(withId(android.R.id.button1)).perform(ViewActions.click());

    }

    private void logout() throws InterruptedException{

        //3)Press Logout Button
        onView(withId(R.id.logout_btn)).perform(ViewActions.click());

        //3.5)Wait
        Thread.sleep(1000);

        //4)Click dialog
        onView(withId(android.R.id.button1)).perform(ViewActions.click());

    }

    private void pushSendDataView() throws InterruptedException{

        //5)Press Send Data Button
        onView(withId(R.id.push_send_data_view_btn)).perform(ViewActions.click());

        //6)Wait until we are on SendDataActivity
        Thread.sleep(1000);

        //7)Assert UI ELEMENTS
        onView(withId(R.id.sendDataEditText))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
        onView(withId(R.id.sendDatabutton))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

    private void sendData(String data) throws InterruptedException{

        //1)Insert Text into textBox
        onView(withId(R.id.sendDataEditText))
                .perform(ViewActions.typeText(data));

        Espresso.closeSoftKeyboard();


        //2)Click button
        onView(withId(R.id.sendDatabutton))
                .perform(ViewActions.click());

        //4)Assert Success
        Thread.sleep(1000);

        //5)CLose Dialog box
        onView(withId(android.R.id.button1)).perform(ViewActions.click());

    }

}

