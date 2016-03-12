package com.parsable.appetizer.parasable.Model;

import com.parsable.appetizer.parasable.Model.ApiJsonPojo.AuthToken;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Davix on 3/11/16.
 */
public class User extends RealmObject{

    @PrimaryKey
    AuthToken token;

    public User(AuthToken token) {
        this.token = token;
    }

    public AuthToken getToken() {
        return token;
    }

    public void setToken(AuthToken token) {
        this.token = token;
    }
}
