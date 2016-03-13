package com.parsable.appetizer.parasable.Repository

import com.parsable.appetizer.parasable.Event.LoginEvent
import com.parsable.appetizer.parasable.Event.CreateAccountEvent
import com.parsable.appetizer.parasable.Model.ApiJsonPojo.AuthToken
import okhttp3.ResponseBody
import rx.Observable

/**
 * Created by Davix on 3/10/16.
 */

interface IRepository{

    //Sign Up
    fun createAccountAction(event : CreateAccountEvent): Observable<ResponseBody>

    //Login
    fun loginAction(event : LoginEvent): Observable<AuthToken>

    //LogOut
    fun logOut() : Observable<ResponseBody>

    //Send Text
    fun sendText(text : String): Observable<ResponseBody>

    //Send Number
    fun sendNumber(text : String): Observable<ResponseBody>

    fun saveAuthToken(token : AuthToken): Observable<AuthToken>

    fun loadLastAuthToken(): Observable<AuthToken>

    fun autoLogin():Observable<AuthToken>
}