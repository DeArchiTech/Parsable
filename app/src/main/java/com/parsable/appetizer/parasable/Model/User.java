package com.parsable.appetizer.parasable.Model;

import com.parsable.appetizer.parasable.Model.ApiJsonPojo.AuthToken;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Davix on 3/11/16.
 */
public class User extends RealmObject{

    private String token;

    public User() {
    }

    public User(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
