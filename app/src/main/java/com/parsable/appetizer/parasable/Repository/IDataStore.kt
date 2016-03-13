package com.parsable.appetizer.parasable.Repository

import com.parsable.appetizer.parasable.Model.NumData
import com.parsable.appetizer.parasable.Model.TextData
import com.parsable.appetizer.parasable.Model.User
import com.parsable.appetizer.parasable.ParsableEnum
import io.realm.RealmResults
import rx.Observable

/**
 * Created by Davix on 3/8/16.
 */

interface IDataStore {

    fun readTextData(result: ParsableEnum.callBackResult): Observable<RealmResults<TextData>>

    fun readNumData(result: ParsableEnum.callBackResult): Observable<RealmResults<NumData>>


    fun createTextData(data : TextData): Observable<TextData>

    fun createNumData(data : NumData): Observable<NumData>


    fun readUserData(): Observable<RealmResults<User>>

    fun createUserData(data : User): Observable<User>

    fun deleteUserData(data : User): Observable<User>
}
