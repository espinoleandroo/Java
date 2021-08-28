package io.espinoleandroo.java.testing.util;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilTest {

    public static void main(String[] args) {
        String result;
        result = StringUtil.repeat("Hoola", 3);
        assertEquals(result, "HoolaHoolaHoola");
        result = StringUtil.repeat("Hoola", 1);
        assertEquals(result, "Hoola");
    }

    @Test
    public void testRepeat(){
        Assert.assertEquals("HoolaHoolaHoola", StringUtil.repeat("Hoola", 3));
        Assert.assertEquals("Hoola", StringUtil.repeat("Hoola", 1));
    }

    private static void assertEquals(String actual, String expected) {
        if(!actual.equals(expected)){
            throw new RuntimeException(actual + " is not equeal to expected " + expected);
        }
    }
    
    @Test
    public void repeat_string_once() {
    	Assert.assertEquals("Hoola", StringUtil.repeat("Hoola", 1));
    }
    
    
    @Test
    public void repeat_string_multiple_times() {
    	Assert.assertEquals("HoolaHoolaHoola", StringUtil.repeat("Hoola", 3));
    }
    
    @Test
    public void repeat_string_zero_times() {
    	Assert.assertEquals("", StringUtil.repeat("hola", 0));
    }
    
    
    @Test(expected = IllegalArgumentException.class)
    public void repeat_string_negative_times() {
    	Assert.assertEquals("HoolaHoolaHoola", StringUtil.repeat("Hoola", -1));
    }
}