package com.parsable.appetizer.parasable;

import android.os.Build;

import com.parsable.appetizer.parasable.Repository.IRepository;
import com.parsable.appetizer.parasable.Repository.RepositoryImpl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */

@RunWith(RobolectricGradleTestRunner.class)
@Config(sdk = Build.VERSION_CODES.LOLLIPOP)

public class RepositoryImplUnitTest {

    IRepository repository;

    @Before
    public void setUp(){

        this.repository = new RepositoryImpl();

    }

    @Test
    public void testSaveNumData(){

        //Algorithm
        //1)Create Object
        //2)Save Object
        //3)Retrieve Object
        //4)Test Connection
        assert (false);

    }

    @Test
    public void testSaveTextData(){

        assert (false);

    }

    @Test
    public void testGetNumData(){

        assert(false);

    }

    @Test
    public void testGetStringData(){

        assert(false);

    }
}