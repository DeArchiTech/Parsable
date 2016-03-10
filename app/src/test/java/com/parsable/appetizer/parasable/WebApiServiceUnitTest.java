package com.parsable.appetizer.parasable;

import com.parsable.appetizer.parasable.Network.IWebApiService;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

/**
 * Created by Davix on 3/9/16.
 */

@RunWith(RobolectricTestRunner.class)
@Config(sdk = BuildConfig.VERSION_CODE)

public class WebApiServiceUnitTest {

    IWebApiService service;
    MockWebServer server;
    MockResponse userMockResponse;

    String userID = "0";
    String username = "david";
    String email = "davidkwokhochan@gmail.com";
    String password = "abcd1234";

    @Before
    public void setUp(){

    }
}
