package com.parsable.appetizer.parasable;

import android.os.Build;

import com.parsable.appetizer.parasable.Presenter.ILoginPresenter;
import com.parsable.appetizer.parasable.Presenter.LoginPresenterImpl;
import com.parsable.appetizer.parasable.Repository.IDataStore;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

/**
 * Created by Davix on 3/10/16.
 */
@Config(sdk = Build.VERSION_CODES.LOLLIPOP , manifest = "src/main/AndroidManifest.xml")
@RunWith(RobolectricTestRunner.class)
public class LoginPresenterImplUnitTest {

    ILoginPresenter presenter;
    IDataStore repository;

    @Before
    public void setUp(){

        this.presenter = new LoginPresenterImpl(repository);

    }

    @Test
    public void loginActionTest(){

        assert(false);

    }

}
