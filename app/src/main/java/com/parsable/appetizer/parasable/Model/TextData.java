package com.parsable.appetizer.parasable.Model;
import io.realm.RealmObject;
import io.realm.annotations.Required;

/**
 * Created by Davix on 3/8/16.
 */

public class TextData extends RealmObject{

    @Required
    private String data;
    private String result;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
