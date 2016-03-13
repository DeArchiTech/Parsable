package com.parsable.appetizer.parasable.View

import com.parsable.appetizer.parasable.Model.ApiJsonPojo.AuthToken
import com.parsable.appetizer.parasable.ParsableEnum

/**
 * Created by Davix on 3/10/16.
 */
//View should only listen for events triggered
//By the signUp or when the Login buttons
interface ILoginView{

    fun displayActionAndResult(action: ParsableEnum.actionName, result : Boolean)

    fun pushSendDataActivity(token : AuthToken)

}