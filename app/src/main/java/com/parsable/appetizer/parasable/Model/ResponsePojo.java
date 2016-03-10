package com.parsable.appetizer.parasable.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * Created by Davix on 3/10/16.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonRootName("")
public class ResponsePojo {

    @JsonProperty(value = "AuthToken")
    public String AuthToken;

}
