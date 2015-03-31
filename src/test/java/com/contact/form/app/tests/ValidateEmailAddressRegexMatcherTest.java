package com.contact.form.app.tests;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import com.contact.form.app.validation.RegexMatcher;

public class ValidateEmailAddressRegexMatcherTest {
    private static final String EMAIL_ADDRESS_PATTERN = 
    		"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
    		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    
    @Test
    public void validateEmailAddress() {
    	String testEmail = "email@email.com";
        assertThat(testEmail, RegexMatcher.matches(EMAIL_ADDRESS_PATTERN));
    }
}