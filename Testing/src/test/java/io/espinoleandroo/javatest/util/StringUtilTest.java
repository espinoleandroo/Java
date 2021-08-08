package io.espinoleandroo.javatest.util;

public class StringUtilTest {

    public static void main(String[] args) {
        String result;
        result = StringUtil.repeat("Hoola", 3);
        assertEquals(result, "HoolaHoolaHoola");
        result = StringUtil.repeat("Hoola", 1);
        assertEquals(result, "Hoola");

    }

    private static void assertEquals(String actual, String expected) {
        if(!actual.equals(expected)){
            throw new RuntimeException(actual + " is not equeal to expected " + expected);
        }
    }
}