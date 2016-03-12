package com.parsable.appetizer.parasable;

import com.parsable.appetizer.parasable.Event.SendNumberEvent;
import com.parsable.appetizer.parasable.Event.SendTextEvent;
import com.parsable.appetizer.parasable.Model.ApiJsonPojo.AuthToken;
import com.parsable.appetizer.parasable.Presenter.ISendDataPresenter;
import com.parsable.appetizer.parasable.Presenter.SendDataPresenterImpl;
import com.parsable.appetizer.parasable.Repository.IRepository;
import com.parsable.appetizer.parasable.Repository.RepositoryImpl;
import com.parsable.appetizer.parasable.Subscriber.AutoLoginSubscriber;
import com.parsable.appetizer.parasable.Subscriber.SendNumberSubscriber;
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
        repository.blockingAutoLogin(new AutoLoginSubscriber<AuthToken>(repository));
        this.presenter= new SendDataPresenterImpl(repository);
        screen = new ISendDataScreen() {
            @Override
            public void displayActionMessage(@NotNull ParsableEnum.actionName action, boolean result) {
                SendDataPresenterTest.this.viewCalled = true;
            }

            @Override
            public void sendDataButtonPressed() {

            }

            @Override
            public void setPresnter(@NotNull ISendDataPresenter presenter) {

            }
        };
    }

    @Test
    public void sendNumberTest() throws InterruptedException{

        Subscriber<ResponseBody> subscriber = new SendNumberSubscriber<>(screen);
        SendNumberEvent event = new SendNumberEvent(new NumberHelper().generateNumber());
        this.presenter.sendNumberEvent(event, subscriber);

    }

    @Test
    public void sendTextTest(){

        Subscriber<ResponseBody> subscriber = new SendTextSubscriber<>(screen);
        SendTextEvent event = new SendTextEvent( new StringHelper().generateText());
        this.presenter.sendTextEvent(event, subscriber);

    }

}
