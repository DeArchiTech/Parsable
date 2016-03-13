package com.parsable.appetizer.parasable.Presenter

import com.parsable.appetizer.parasable.Event.SendDataEvent
import com.parsable.appetizer.parasable.Model.ApiJsonPojo.AuthToken
import com.parsable.appetizer.parasable.Subscriber.AutoLoginSubscriber
import com.parsable.appetizer.parasable.View.ISendDataScreen

/**
 * Created by Davix on 3/11/16.
 */
interface ISendDataPresenter{

    fun sendDataEvent(event : SendDataEvent, view : ISendDataScreen)

    fun autoLoginEvent(subcriber: AutoLoginSubscriber<AuthToken>)

}