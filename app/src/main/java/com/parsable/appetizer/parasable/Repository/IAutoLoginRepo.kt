package com.parsable.appetizer.parasable.Repository

import com.parsable.appetizer.parasable.Model.ApiJsonPojo.AuthToken
import rx.Subscriber

/**
 * Created by Davix on 3/11/16.
 */

interface IAutoLoginRepo {

    fun autoLogin(subscriber: Subscriber<AuthToken>)
}
