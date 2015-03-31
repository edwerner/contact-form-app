package com.contact.form.app.tests;

import org.hibernate.validator.constraints.SafeHtml;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import com.contact.form.app.validation.RegexMatcher;

public class ValidateScriptTagRegexMatcherTest {
    private String SCRIPT_TAG_PATTERN = "([^<>]*[><])*";
    
    @Test
    @SafeHtml(whitelistType = SafeHtml.WhiteListType.SIMPLE_TEXT)
    public void validateScriptTag() {
    	String phoneNumber = "<script>alert('JavaScript alert!')</script>";
        assertThat(phoneNumber, RegexMatcher.matches(SCRIPT_TAG_PATTERN));
    }
}