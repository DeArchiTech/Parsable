package com.parsable.appetizer.parasable.Model.ApiJsonPojo;

/**
 * Created by Davix on 3/9/16.
 */
public class CreatApiPojo implements IApiJsonPojo {

    public String api = "create";
    public String email = "";
    public String password = "";

    public CreatApiPojo(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
