package com.parsable.appetizer.parasable.Presenter

import com.parsable.appetizer.parasable.Event.LoginEvent
import com.parsable.appetizer.parasable.Event.CreateAccountEvent
import com.parsable.appetizer.parasable.Model.ApiJsonPojo.AuthToken
import okhttp3.ResponseBody
import rx.Subscriber

/**
 * Created by Davix on 3/10/16.
 */
interface ILoginPresenter{

    //Login Action by sending login info
    //Returns an observable where you can define your subscriber
    fun createAccountAction(event : CreateAccountEvent, subscriber: Subscriber<ResponseBody>)

    fun loginAction(event : LoginEvent, subscriber : Subscriber<AuthToken>)

    fun logOutAction(subscriber: Subscriber<ResponseBody>)
}