package com.parsable.appetizer.parasable.View

import com.parsable.appetizer.parasable.ParsableEnum

/**
 * Created by Davix on 3/11/16.
 */
interface ISendDataScreen{

    fun displayActionMessage(action: ParsableEnum.actionName , result: Boolean)

    fun sendDataButtonPressed()

}