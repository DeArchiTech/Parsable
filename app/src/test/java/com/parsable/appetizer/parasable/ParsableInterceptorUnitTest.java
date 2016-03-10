package com.parsable.appetizer.parasable;
import android.os.Build;
import com.parsable.appetizer.parasable.Network.ParsableInterceptor;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.easymock.PowerMock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import static org.mockito.Mockito.*;

/**
 * Created by Davix on 3/9/16.
 */
@RunWith(PowerMockRunner.class)
@Config(sdk = Build.VERSION_CODES.LOLLIPOP)
@PrepareForTest({Request.class ,Request.Builder.class ,Response.class, Interceptor.Chain.class})
public class ParsableInterceptorUnitTest {

    @Test
    public void testIntercept(){

        ParsableInterceptor interceptor = new ParsableInterceptor();

        //  create mock
        Interceptor.Chain chain = Mockito.mock(Interceptor.Chain.class);
        Response expectedResponse = PowerMockito.mock(Response.class);
        Response acturalResponse = null;
        Request mockRequest = Mockito.mock(Request.class);
        Request.Builder builder = Mockito.mock(Request.Builder.class);
        try{

            doReturn(mockRequest).when(chain).request();
            doReturn(builder).when(mockRequest).newBuilder();
            //Some how this bypass the return type error where as doReturn fails
            when(chain.proceed(chain.request())).thenReturn(expectedResponse);
            doReturn(builder).when(builder).addHeader("deviceplatform","android");
            doReturn(builder).when(builder).addHeader("User-Agent"
                    , "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:38.0) Gecko/20100101 Firefox/38.0");
            doReturn(builder).when(builder).removeHeader("User-Agent");
            doReturn(mockRequest).when(builder).build();
            acturalResponse = interceptor.intercept(chain);

        }catch(Exception e){

            assert (false);
            e.printStackTrace();
        }
        assert(acturalResponse != null);
        Assert.assertEquals(expectedResponse, acturalResponse);

    }

}
