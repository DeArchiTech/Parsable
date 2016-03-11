package com.parsable.appetizer.parasable.Event;

/**
 * Created by Davix on 3/10/16.
 */
public class CreateAccountEvent {

    public String email;
    public String password;

    public CreateAccountEvent(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
