package com.parsable.appetizer.parasable;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.core.deps.guava.util.concurrent.ThreadFactoryBuilder;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import com.parsable.appetizer.parasable.Util.StringHelper;
import com.parsable.appetizer.parasable.View.LoginActivity;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.*;

//Need to run this with instrumental test
@RunWith(AndroidJUnit4.class)
public class LoginActivityUITest {

    @Rule
    public final ActivityTestRule<LoginActivity> login = new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void testUIElements(){

        //1)Assert there is an email loggin form
        onView(withId(R.id.email_login_form))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));

        //2)Assert there is an input box
        onView(withId(R.id.password))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));

        //3)Assert there is a loggin button
        onView(withId(R.id.password))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

    @Test
    public void createAccountButtonSuccessTest() {

        //1)Input Keyboard event for email
        onView(withId(R.id.email)).perform(ViewActions.typeText(new StringHelper().generateEmail()));

        //2)Input Keyboard event for password
        onView(withId(R.id.password)).perform(ViewActions.typeText(new StringHelper().createLoginPassword()));

        //3)Press Create Button
        onView(withId(R.id.create_accnt_btn)).perform(ViewActions.click());

        //4)Click dialog
        onView(withId(android.R.id.button1)).perform(ViewActions.click());

        //5)Assert That Push Send data Activity Button is Visible
        onView(withId(R.id.push_send_data_view_btn)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));

    }

    @Test
    public void loginButtonPressedSuccessTest() {

        //1)Input Keyboard event for email
        onView(withId(R.id.email)).perform(ViewActions.typeText(new StringHelper().createLoginEmail()));

        //2)Input Keyboard event for password
        onView(withId(R.id.password)).perform(ViewActions.typeText(new StringHelper().createLoginPassword()));

        //3)Press Login Button
        onView(withId(R.id.login_btn)).perform(ViewActions.click());

        //4)Click dialog
        onView(withId(android.R.id.button1)).perform(ViewActions.click());

        //5)Assert Push Send Data Button Clickable
        onView(withId(R.id.push_send_data_view_btn)).check( ViewAssertions.matches(ViewMatchers.isDisplayed()));

    }

    @Test
    public void loginButtonPressedFailTest() {

        //1)Input Keyboard event for email
        onView(withId(R.id.email)).perform(ViewActions.typeText(new StringHelper().createLoginEmail()));

        //2)Input Keyboard event for password
        onView(withId(R.id.password)).perform(ViewActions.typeText(""));

        //3)Press Login Button
        onView(withId(R.id.login_btn)).perform(ViewActions.click());


        //4)Click dialog
        onView(withId(android.R.id.button1)).perform(ViewActions.click());
        //4)Assert Push Send Data Button Not Clickable

    }

    @Test
    public void logoutButtonPressedPassTest() {

        //1)Input Keyboard event for email
        onView(withId(R.id.email)).perform(ViewActions.typeText(new StringHelper().createLoginEmail()));

        //2)Input Keyboard event for password
        onView(withId(R.id.password)).perform(ViewActions.typeText(new StringHelper().createLoginPassword()));

        //3)Press Login Button
        onView(withId(R.id.login_btn)).perform(ViewActions.click());

        //4)Click dialog
        onView(withId(android.R.id.button1)).perform(ViewActions.click());

        //4)Press Logout Button
        onView(withId(R.id.login_btn)).perform(ViewActions.click());

        //4)Click dialog
        onView(withId(android.R.id.button1)).perform(ViewActions.click());
    }


    @Test
    public void startDataActivityTest() throws InterruptedException{

        //1)Input Keyboard event for email
        onView(withId(R.id.email)).perform(ViewActions.typeText(new StringHelper().createLoginEmail()));

        //2)Input Keyboard event for password
        onView(withId(R.id.password)).perform(ViewActions.typeText(new StringHelper().createLoginPassword()));

        //3)Press Login Button
        onView(withId(R.id.login_btn)).perform(ViewActions.click());

        //3.5)Wait
        Thread.sleep(1000);

        //4)Click dialog
        onView(withId(android.R.id.button1)).perform(ViewActions.click());

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

}

