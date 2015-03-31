package com.contact.form.app.tests;

import static org.junit.Assert.assertEquals;
import com.contact.form.app.domain.Contact;
import org.junit.Test;

public class ContactFormTest {

	@Test
	public void testFirstName() {
		Contact contact = new Contact();
		contact.setFirstName("FirstName");
		 assertEquals(contact.getFirstName(), "FirstName");
	}
	
	@Test
	public void testLastName() {
		Contact contact = new Contact();
		contact.setLastName("LastName");
		 assertEquals(contact.getLastName(), "LastName");
	}
	
	@Test
	public void testEmailAddress() {
		Contact contact = new Contact();
		contact.setEmailAddress("email@email.com");
		 assertEquals(contact.getEmailAddress(), "email@email.com");
	}
	
	@Test
	public void testPhoneNumber() {
		Contact contact = new Contact();
		contact.setPhoneNumber("555-555-5555");
		 assertEquals(contact.getPhoneNumber(), "555-555-5555");
	}
	
	@Test
	public void testMessage() {
		Contact contact = new Contact();
		contact.setMessage("Hello World!");
		 assertEquals(contact.getMessage(), "Hello World!");
	}
}