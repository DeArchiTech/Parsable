package com.parsable.appetizer.parasable.Model;
import com.parsable.appetizer.parasable.Enum;
import io.realm.RealmObject;
import io.realm.annotations.Required;

/**
 * Created by Davix on 3/8/16.
 */

public class TextData extends RealmObject{

    @Required
    private String data;
    private Enum.callBackResult result;

}
