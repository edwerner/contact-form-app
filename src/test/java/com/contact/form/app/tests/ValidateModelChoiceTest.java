package com.contact.form.app.tests;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import com.contact.form.app.validation.RegexMatcher;

public class ValidateModelChoiceTest {
    private String MODEL_CHOICE_PATTERN = "^(?!model$).*";
    
    @Test
    public void validatePhoneNumber() {
        String model = "Model";
        assertThat(model, RegexMatcher.matches(MODEL_CHOICE_PATTERN));
    }
}