package com.parsable.appetizer.parasable;
import java.util.UUID;

/**
 * Created by Davix on 3/9/16.
 */
public class StringHelper {

    public String generateEmail(){

        String randomString = UUID.randomUUID().toString().substring(0,4);
        StringBuilder sb = new StringBuilder();
        sb.append("david");
        sb.append(randomString);
        sb.append("@gmail.com");
        return sb.toString();
    }

}
