package com.parsable.appetizer.parasable.Model.ApiJsonPojo;

/**
 * Created by Davix on 3/10/16.
 */
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import java.io.Serializable;

/**
 * Created by Davix on 3/10/16.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
@JsonRootName("")
public class AuthToken implements Serializable {

    @JsonProperty(value = "AuthToken")
    public String AuthToken = "" ;

}
