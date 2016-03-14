package com.parsable.appetizer.parasable.Repository;

import com.parsable.appetizer.parasable.Model.ApiJsonPojo.AuthToken;
import com.parsable.appetizer.parasable.Model.NumData;
import com.parsable.appetizer.parasable.Model.TextData;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

/**
 * Created by Davix on 3/8/16.
 */

//Note:
//Can't Block Main Thread
//Make sure its thread save
public class CacheData implements IUserData {

    Realm realm;
    AuthToken token;
    List<TextData> textData;
    List<NumData> numData;

    @Override
    public void appendTextData(@NotNull TextData data) {

        this.textData.add(data);

    }

    @Override
    public void appendNumberData(@NotNull NumData data) {

        this.numData.add(data);

    }

    //Todo Refactor with Dagger, use singleTon for now
    private  static IUserData instance;

    public static IUserData getInstance() {
        return instance;
    }

    public static void setInstance(IUserData instance) {
        CacheData.instance = instance;
    }

    public CacheData(Realm realm) {

        this.realm = realm;
        this.textData = new ArrayList<TextData>();
        this.numData = new ArrayList<NumData>();

    }

    @Override
    public void cacheAuthTotken(@NotNull AuthToken token) {

        this.token = token;

    }

    @NotNull
    @Override
    public AuthToken readCachedAuthToken() {
        return this.token;
    }
}
