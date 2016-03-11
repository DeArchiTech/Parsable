package com.parsable.appetizer.parasable;

import android.os.Build;

import com.parsable.appetizer.parasable.Presenter.ILoginPresenter;
import com.parsable.appetizer.parasable.View.ILoginView;
import com.parsable.appetizer.parasable.View.LoginActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

/**
 * Created by Davix on 3/10/16.
 */
@RunWith(RobolectricTestRunner.class)
@Config(sdk = Build.VERSION_CODES.LOLLIPOP)
public class LoginViewTest {

    ILoginView loginView;
    ILoginPresenter presenter;

    @Before
    public void setUp(){

        LoginActivity activity = new LoginActivity();
        this.loginView = activity;
        this.presenter = new MockLoginPresenter(activity);
        activity.setPresenter(this.presenter);

    }

    @Test
    public void displayActionAndResultTest(){

        this.loginView.displayActionAndResult(ParsableEnum.actionName.Login , true);
        this.loginView.displayActionAndResult(ParsableEnum.actionName.Login , false);
        this.loginView.displayActionAndResult(ParsableEnum.actionName.LogOut , true);
        this.loginView.displayActionAndResult(ParsableEnum.actionName.LogOut , false);
        this.loginView.displayActionAndResult(ParsableEnum.actionName.CreateAccount , true);
        this.loginView.displayActionAndResult(ParsableEnum.actionName.CreateAccount , false);

    }



}
