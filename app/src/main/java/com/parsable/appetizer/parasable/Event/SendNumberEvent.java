package com.parsable.appetizer.parasable.Event;

/**
 * Created by Davix on 3/11/16.
 */
public class SendNumberEvent {

    public String text;

    public SendNumberEvent(double aDouble){
        this.text = String.valueOf(aDouble);
    }

}
