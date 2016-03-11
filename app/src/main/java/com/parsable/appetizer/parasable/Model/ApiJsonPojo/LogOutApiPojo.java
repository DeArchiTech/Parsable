package com.parsable.appetizer.parasable.Model.ApiJsonPojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.io.Serializable;

/**
 * Created by Davix on 3/9/16.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonRootName("")
public class LogOutApiPojo implements IApiJsonPojo ,Serializable {

    @JsonProperty(value = "api")
    public String api = "logout";

}