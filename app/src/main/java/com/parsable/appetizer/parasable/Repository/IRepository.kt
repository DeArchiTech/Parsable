package com.parsable.appetizer.parasable.Repository

import com.parsable.appetizer.parasable.Model.NumData
import com.parsable.appetizer.parasable.Model.TextData
import rx.Observable

/**
 * Created by Davix on 3/8/16.
 */

interface IRepository {

    fun getTextData(errored: Boolean): Observable<List<TextData>>

    fun getNumData(errored : Boolean): Observable<List<NumData>>

    fun saveTextData(data : TextData): Observable<TextData>

    fun saveNumData(data : NumData): Observable<NumData>

}
