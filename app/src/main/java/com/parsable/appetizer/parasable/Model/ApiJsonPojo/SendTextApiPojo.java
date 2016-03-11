package com.parsable.appetizer.parasable.Model.ApiJsonPojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.io.Serializable;

/**
 * Created by Davix on 3/9/16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName("")
public class SendTextApiPojo implements IApiJsonPojo, Serializable{

    @JsonProperty("api")
    public String api = "sendText";

    @JsonProperty("text")
    public String text = "" ;

    public SendTextApiPojo(String text) {
        this.text = text;
    }
}
