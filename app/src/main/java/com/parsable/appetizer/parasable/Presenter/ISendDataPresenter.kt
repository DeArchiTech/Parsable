package com.parsable.appetizer.parasable.Presenter

import com.parsable.appetizer.parasable.Event.SendNumberEvent
import com.parsable.appetizer.parasable.Event.SendTextEvent
import okhttp3.ResponseBody
import rx.Subscriber

/**
 * Created by Davix on 3/11/16.
 */
interface ISendDataPresenter{

    fun sendTextEvent(event : SendTextEvent, subscriber : Subscriber<ResponseBody>)

    fun sendNumberEvent(event : SendNumberEvent, subcriber : Subscriber<ResponseBody>)

}