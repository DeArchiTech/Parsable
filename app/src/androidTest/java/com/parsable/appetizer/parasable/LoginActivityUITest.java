package com.parsable.appetizer.parasable;
import android.support.test.InstrumentationRegistry;
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

    //No Need to test displayAction Result all four cases
    @Test
    public void loginButtonPressedSuccessTest() {

        //1)Input Keyboard event for email
        onView(withId(R.id.email)).perform(ViewActions.typeText(new StringHelper().generateLoginEmail()));

        //2)Input Keyboard event for password
        onView(withId(R.id.password)).perform(ViewActions.typeText(new StringHelper().createLoginPassword()));

        //3)Press Login Button
        onView(withId(R.id.login_btn)).perform(ViewActions.click());

        //4)Assert Push Send Data Button Clickable

    }

    @Test
    public void loginButtonPressedFailTest() {

        //1)Input Keyboard event for email
        onView(withId(R.id.email)).perform(ViewActions.typeText(new StringHelper().generateLoginEmail()));

        //2)Input Keyboard event for password
        onView(withId(R.id.password)).perform(ViewActions.typeText(new StringHelper().createLoginPassword()));

        //3)Press Login Button
        onView(withId(R.id.login_btn)).perform(ViewActions.click());

        //4)Assert Push Send Data Button Not Clickable

    }

    @Test
    public void displayLoginPassTest() {

        InstrumentationRegistry.getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                LoginActivityUITest.this.login.getActivity().displayActionAndResult(ParsableEnum.actionName.Login , true);
            }
        });

    }

    @Test
    public void displayLoginFailTest() {


        InstrumentationRegistry.getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                LoginActivityUITest.this.login.getActivity().displayActionAndResult(ParsableEnum.actionName.Login , false);
            }
        });
    }

    @Test
    public void displayLogoutPassTest() {

        InstrumentationRegistry.getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                LoginActivityUITest.this.login.getActivity().displayActionAndResult(ParsableEnum.actionName.LogOut , true);

            }
        });
    }

    @Test
    public void displayLogoutFailTest() {

        InstrumentationRegistry.getInstrumentation().runOnMainSync(new Runnable() {
            @Override
            public void run() {
                LoginActivityUITest.this.login.getActivity().displayActionAndResult(ParsableEnum.actionName.LogOut , false);

            }
        });
    }

    @Test
    public void pushSendDataActivityButtonVisibleTest() {

        //1)Input Keyboard event for email
        onView(withId(R.id.email)).perform(ViewActions.typeText("david@parsable"));

        //2)Input Keyboard event for password
        onView(withId(R.id.password)).perform(ViewActions.typeText("parsable"));

        //3)Press Login Button
        onView(withId(R.id.login_btn)).perform(ViewActions.click());


        //4)Assert That Push Send data Activity Button is Visible
        onView(withId(R.id.push_send_data_view_btn)).check( ViewAssertions.matches(ViewMatchers.isDisplayed()));


    }

}

