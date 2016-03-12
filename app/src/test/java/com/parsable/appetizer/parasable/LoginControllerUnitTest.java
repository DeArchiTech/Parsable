package com.parsable.appetizer.parasable;

import android.util.Log;

import com.parsable.appetizer.parasable.Presenter.ILoginPresenter;
import com.parsable.appetizer.parasable.View.Controller.ILoginController;
import com.parsable.appetizer.parasable.View.LoginActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.robolectric.RobolectricTestRunner;

/**
 * Created by Davix on 3/10/16.
 */
@RunWith(RobolectricTestRunner.class)
public class LoginControllerUnitTest {

    ILoginController loginController;
    ILoginPresenter loginPresenter;

    @Before
    public void setUp(){

        LoginActivity activity = new LoginActivity();
        loginController = activity;
        loginPresenter = PowerMockito.mock(ILoginPresenter.class);
        activity.setPresenter(loginPresenter);

    }

    @Test
    public void createAccountButtonPressedTest(){

        this.loginController.createAccountButtonPressed();
    }

    @Test
    public void loginButtonPressedTest(){

        this.loginController.loginButtonPressed();

    }

    @Test
    public void logoutButtonPressedTest(){

        this.loginController.logoutButtonPressed();

    }

    @Test
    public void sendDataButtonPressedTest(){

        this.loginController.sendDataButtonPressed();

    }


}
