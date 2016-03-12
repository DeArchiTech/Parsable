package com.parsable.appetizer.parasable.Util;

import android.content.Context;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by Davix on 3/11/16.
 */
public class RealmHelper {

    public Realm getRealm(Context context){

        RealmConfiguration realmConfig = new RealmConfiguration.Builder(context).build();
        Realm realm = Realm.getInstance(realmConfig);
        return realm;

    }
}
