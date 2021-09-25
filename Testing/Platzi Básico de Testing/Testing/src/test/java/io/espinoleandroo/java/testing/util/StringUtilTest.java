package io.espinoleandroo.java.testing.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilTest {
	
	@Test
	public void a_string_is_not_empty() {
		assertFalse(StringUtil.isEmpty("Hello Platzi from Java with JUnit =D"));
	}
	
	@Test
	public void this_is_an_empty_string() {
		assertTrue(StringUtil.isEmpty(""));
	}
	
	@Test
	public void null_is_empty() {
		assertTrue(StringUtil.isEmpty(null));
	}
	
	@Test
	public void a_string_with_spaces_is_empty() {
		assertTrue(StringUtil.isEmpty("        "));
	}

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