package com.parsable.appetizer.parasable.Repository

import com.parsable.appetizer.parasable.Model.NumData
import com.parsable.appetizer.parasable.Model.TextData
import rx.Observable

/**
 * Created by Davix on 3/8/16.
 */

interface IRepository {

    fun readTextData(errored: Boolean): Observable<List<TextData>>

    fun readNumData(errored : Boolean): Observable<List<NumData>>

    fun createTextData(data : TextData): Observable<TextData>

    fun createNumData(data : NumData): Observable<NumData>

}
