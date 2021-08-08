package io.espinoleandroo.javatest.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class PasswordUtilTest {

    @Test
    public void weak_when_has_less_than_8_letters(){
        assertEquals(PasswordUtil.SecurityLevel.WEAK, PasswordUtil.assessPassword("1234567"));
    }

    @Test
    public void weak_when_has_only_letters(){
        assertEquals(PasswordUtil.SecurityLevel.WEAK, PasswordUtil.assessPassword("asdfghjkl"));
    }

    @Test
    public void medium_when_has_letters_and_numbers(){
        assertEquals(PasswordUtil.SecurityLevel.MEDIUM, PasswordUtil.assessPassword("asdf123456"));
    }

    @Test
    public void medium_when_has_letters_and_numbers_and_symbols(){
        assertEquals(PasswordUtil.SecurityLevel.STRONG, PasswordUtil.assessPassword("asdf123456*"));
    }

}