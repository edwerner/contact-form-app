package com.contact.form.app.tests;

import java.util.Set;
import javax.validation.ConstraintViolation;
import org.hibernate.validator.HibernateValidator;
import org.junit.Before;
import org.junit.Test;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import static org.junit.Assert.assertTrue;

import com.contact.form.app.domain.Contact;

public class FormValidationTest {
    private LocalValidatorFactoryBean localValidatorFactory;
 
    @Before
    public void setup() {
        localValidatorFactory = new LocalValidatorFactoryBean();
        localValidatorFactory.setProviderClass(HibernateValidator.class);
        localValidatorFactory.afterPropertiesSet();
    }
    
    @Test
    public void testContact() {
        final Contact contact = new Contact();
        contact.setFirstName("FirstName");
		contact.setLastName("LastName");
		contact.setEmailAddress("email@email.com");
		contact.setPhoneNumber("555-555-5555");
		contact.setModel("Model");
		contact.setMessage("Hello World!");
        Set<ConstraintViolation<Contact>> constraintViolations = localValidatorFactory.validate(contact);
        assertTrue("Expected validation error not found", constraintViolations.size() == 0);
    }
}