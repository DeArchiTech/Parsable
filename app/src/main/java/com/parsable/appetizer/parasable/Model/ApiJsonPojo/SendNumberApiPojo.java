package com.parsable.appetizer.parasable.Model.ApiJsonPojo;

/**
 * Created by Davix on 3/9/16.
 */
public class SendNumberApiPojo implements IApiJsonPojo{

    public String api = "sendNumber";
    public double text = 0.0;

    public SendNumberApiPojo(double num) {
        this.text = num;
    }
}
