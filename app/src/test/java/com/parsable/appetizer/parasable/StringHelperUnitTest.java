package com.parsable.appetizer.parasable;

import com.parsable.appetizer.parasable.Util.StringHelper;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

/**
 * Created by Davix on 3/11/16.
 */
@RunWith(RobolectricTestRunner.class)

public class StringHelperUnitTest {

    StringHelper helper;

    @Before
    public void setUp(){

        this.helper = new StringHelper();

    }

    @Test
    public void inputIsANumberTest(){

        assert( this.helper.inputIsANumber("") == false);
        assert( this.helper.inputIsANumber(null) == false);
        assert( this.helper.inputIsANumber("123abddcd") == false);
        assert( this.helper.inputIsANumber("3") == true);
        assert( this.helper.inputIsANumber("33.33") == true);
        assert( this.helper.inputIsANumber("33..33") == false);

    }
}
