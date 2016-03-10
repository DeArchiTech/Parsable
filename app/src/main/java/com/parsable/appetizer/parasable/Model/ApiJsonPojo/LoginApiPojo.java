package com.parsable.appetizer.parasable.Model.ApiJsonPojo;

/**
 * Created by Davix on 3/9/16.
 */
public class LoginApiPojo implements IApiJsonPojo {

    public String login = "login";
    public String email = "";
    public String password = "";

    public LoginApiPojo(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
