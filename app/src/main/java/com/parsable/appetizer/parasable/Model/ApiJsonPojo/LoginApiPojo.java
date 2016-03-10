package com.parsable.appetizer.parasable.Model.ApiJsonPojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * Created by Davix on 3/9/16.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonRootName("")
public class LoginApiPojo implements IApiJsonPojo {

    @JsonProperty(value = "api")
    public String api = "login";

    @JsonProperty(value = "email")
    public String email = "";

    @JsonProperty(value = "password")
    public String password = "";

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
