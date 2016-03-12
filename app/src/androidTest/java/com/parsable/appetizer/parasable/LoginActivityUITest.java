package com.parsable.appetizer.parasable;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
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
    public void startDataActivityTest() {

        //1)Input Keyboard event for email
        onView(withId(R.id.email)).perform(ViewActions.typeText(new StringHelper().createLoginEmail()));

        //2)Input Keyboard event for password
        onView(withId(R.id.password)).perform(ViewActions.typeText(new StringHelper().createLoginPassword()));

        //3)Press Login Button
        onView(withId(R.id.login_btn)).perform(ViewActions.click());

        //4)Click dialog
        onView(withId(android.R.id.button1)).perform(ViewActions.click());

        //5)Press Send Data Button
        onView(withId(R.id.push_send_data_view_btn)).perform(ViewActions.click());

        //6)Assert on SendDataActivity
    }

}

