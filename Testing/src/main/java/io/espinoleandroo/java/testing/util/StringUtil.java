package io.espinoleandroo.java.testing.util;

public class StringUtil {
    public static String repeat(String string, int times){
        String result = "";

        if(times < 0) {
        	throw new IllegalArgumentException("negative times not allowed");
        }
        for (int i = 0; i < times; i++){
            result += string;
        }

        return  result;
    }
}
