package com.parsable.appetizer.parasable.Model.ApiJsonPojo;

/**
 * Created by Davix on 3/9/16.
 */
public class SendNumApiPojo implements IApiJsonPojo{

    public String api = "sendNum";
    public double number = 0.0;

    public SendNumApiPojo(double num) {
        this.number = num;
    }
}
