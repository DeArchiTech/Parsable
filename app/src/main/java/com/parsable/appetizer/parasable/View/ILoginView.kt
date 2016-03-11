package com.parsable.appetizer.parasable.View

/**
 * Created by Davix on 3/10/16.
 */
//View should only listen for events triggered
//By the signUp or when the Login buttons
interface ILoginView{

    fun displayActionAndResult(action: String, result : Boolean)

}