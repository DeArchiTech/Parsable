package com.parsable.appetizer.parasable.Model;

import com.parsable.appetizer.parasable.Enum;
import io.realm.RealmObject;
import io.realm.annotations.Required;

/**
 * Created by Davix on 3/8/16.
 */

public class NumData extends RealmObject{

    @Required
    private double number;
    private Enum.callBackResult result;

}
