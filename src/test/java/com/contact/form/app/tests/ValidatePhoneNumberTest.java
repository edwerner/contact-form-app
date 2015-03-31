package com.contact.form.app.tests;

import org.junit.Test;
import com.contact.form.app.validation.RegexMatcher;
import static org.junit.Assert.assertThat;

public class ValidatePhoneNumberTest {
    private String PHONE_NUMBER_PATTERN = "\\d{3}-\\d{3}-\\d{4}";
    
    @Test
    public void validatePhoneNumber() {
    	String phoneNumber = "555-555-5555";
        assertThat(phoneNumber, RegexMatcher.matches(PHONE_NUMBER_PATTERN));
    }
}