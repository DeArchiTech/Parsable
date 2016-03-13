package com.parsable.appetizer.parasable;

import com.parsable.appetizer.parasable.Event.SendDataEvent;
import com.parsable.appetizer.parasable.Model.ApiJsonPojo.AuthToken;
import com.parsable.appetizer.parasable.Presenter.ISendDataPresenter;
import com.parsable.appetizer.parasable.Presenter.SendDataPresenterImpl;
import com.parsable.appetizer.parasable.Repository.IRepository;
import com.parsable.appetizer.parasable.Repository.RepositoryImpl;
import com.parsable.appetizer.parasable.Subscriber.AutoLoginSubscriber;
import com.parsable.appetizer.parasable.Subscriber.SendTextSubscriber;
import com.parsable.appetizer.parasable.Util.NumberHelper;
import com.parsable.appetizer.parasable.Util.StringHelper;
import com.parsable.appetizer.parasable.View.ISendDataScreen;

import org.jetbrains.annotations.NotNull;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import okhttp3.ResponseBody;
import rx.Subscriber;

/**
 * Created by Davix on 3/11/16.
 */
@RunWith(RobolectricTestRunner.class)
public class SendDataPresenterTest {

    ISendDataPresenter presenter;
    ISendDataScreen screen;
    boolean viewCalled = false;

    @Before
    public void setUp(){

        IRepository repository = new RepositoryImpl();
        this.presenter= new SendDataPresenterImpl(repository);
        this.screen = new ISendDataScreen() {
            @Override
            public void displayActionMessage(@NotNull ParsableEnum.actionName action, boolean result) {

            }

            @Override
            public void sendDataButtonPressed() {

            }

            @Override
            public void setPresnter(@NotNull ISendDataPresenter presenter) {

            }
        };
        this.presenter.autoLoginEvent(new AutoLoginSubscriber<>(this.screen));
    }

    @Test
    public void sendNumberTest() throws InterruptedException{

        SendDataEvent event = new SendDataEvent(new NumberHelper().generateNumberInString());
        this.presenter.sendDataEvent(event , this.screen);

    }

    @Test
    public void sendTextTest(){

        SendDataEvent event = new SendDataEvent(new StringHelper().generateText());
        this.presenter.sendDataEvent(event , this.screen);

    }

    @Test
    public void autoLoginTest(){

        AutoLoginSubscriber<AuthToken> subscriber
                = new AutoLoginSubscriber<AuthToken>(this.screen);
        this.presenter.autoLoginEvent(subscriber);

    }

}
