package com.parsable.appetizer.parasable.Repository

import com.parsable.appetizer.parasable.Model.ApiJsonPojo.AuthToken
import com.parsable.appetizer.parasable.Model.NumData
import com.parsable.appetizer.parasable.Model.TextData
import com.parsable.appetizer.parasable.Model.User
import com.parsable.appetizer.parasable.ParsableEnum
import io.realm.RealmResults
import rx.Observable

/**
 * Created by Davix on 3/8/16.
 */

interface IUserData {

    fun cacheAuthTotken(token : AuthToken)

    fun readCachedAuthToken() : AuthToken

    fun appendTextData(data : TextData)

    fun appendNumberData(data : NumData)

}
