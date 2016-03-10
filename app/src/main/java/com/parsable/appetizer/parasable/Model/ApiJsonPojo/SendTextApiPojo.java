package com.parsable.appetizer.parasable.Model.ApiJsonPojo;

/**
 * Created by Davix on 3/9/16.
 */
public class SendTextApiPojo implements IApiJsonPojo{

    public String api = "sendText";
    public String text = "" ;

    public SendTextApiPojo(String text) {
        this.text = text;
    }
}
