package com.parsable.appetizer.parasable.Model;

import com.parsable.appetizer.parasable.Enum;
import io.realm.RealmObject;

/**
 * Created by Davix on 3/8/16.
 */

public class NumData extends RealmObject{

    private double data;
    private String result;

    public double getData() {
        return data;
    }

    public void setData(double data) {
        this.data = data;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}
