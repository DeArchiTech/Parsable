package com.parsable.appetizer.parasable.Util;
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

    public String createLoginEmail(){

        return "david@parsable.com";
    }

    public String createLoginPassword(){

        return "parsable";
    }


    public boolean inputIsANumber(String input) {

        boolean result = true;

        //Return True Only If it is parsable into a number
        if (input == null || input.isEmpty())
            return false;

        boolean inputHasDecimal = false;
        loop:
        for (char c : input.toCharArray()) {

            //Break loop if we have two decimals
            if(isADecimal(c)){

                if(inputHasDecimal){
                    result= false;
                }else{
                    inputHasDecimal = true;
                }

            }else if (!isADigit(c)) {

                //break loop if we don't have a decimal or digit
                result = false;

            }

            if(result == false)
                break loop;

        }

        return result;

    }

    private boolean isADigit(Character c){

        return c<'9' && c > '0';

    }

    private boolean isADecimal(Character c){

        return c == '.';

    }

    public String generateText(){

        return String.valueOf("randomValue");

    }
}
