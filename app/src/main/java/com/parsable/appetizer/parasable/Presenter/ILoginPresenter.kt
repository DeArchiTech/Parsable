package com.parsable.appetizer.parasable.Presenter

import com.parsable.appetizer.parasable.Event.LoginEvent
import com.parsable.appetizer.parasable.Event.CreateAccountEvent
import okhttp3.ResponseBody
import rx.Observable

/**
 * Created by Davix on 3/10/16.
 */
interface ILoginPresenter{

    //Login Action by sending login info
    //Returns an observable where you can define your subscriber
    fun loginAction(event : LoginEvent) : Observable<ResponseBody>

    fun signUpAction(event : CreateAccountEvent) : Observable<ResponseBody>

    fun logOutAction() : Observable<ResponseBody>
}