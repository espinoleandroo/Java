package io.espinoleandroo.javatest.util;

public class StringUtil {
    public static String repeat(String string, int times){
        String result = "";

        for (int i = 0; i < times; i++){
            result += string;
        }

        return  result;
    }
}
