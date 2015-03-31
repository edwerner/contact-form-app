package com.contact.form.app.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.SafeHtml;

@Entity
@Table(name="contact")
public class Contact {
	
	@Id 
	@GeneratedValue 
	private long id;
	
	@NotBlank(message = "First name cannot be blank")
	@SafeHtml(whitelistType = SafeHtml.WhiteListType.NONE, message = "No HTML/JavaScript allowed")
	@Pattern(regexp = "^(?!.*[`~$&+.,:;=?@#|/'<>^*(){}%!\"\\[\\]-]).*$", message = "No special characters allowed")
	@Size(max = 75, message = "Cannot be longer than {max} characters")
	private String firstName;
	
	@NotBlank(message = "Last name cannot be blank")
	@SafeHtml(whitelistType = SafeHtml.WhiteListType.NONE, message = "No HTML/JavaScript allowed")
	@Pattern(regexp = "^(?!.*[`~$&+.,:;=?@#|/'<>^*(){}%!\"\\[\\]-]).*$", message = "No special characters allowed")
	@Size(max = 75, message = "Cannot be longer than {max} characters")
	private String lastName;
	
	@NotBlank(message = "Email address cannot be blank")
	@Email(message="Please provide a valid email address")
	@SafeHtml(whitelistType = SafeHtml.WhiteListType.NONE, message = "No HTML/JavaScript allowed")
	@Size(max = 50, message = "Cannot be longer than {max} characters")
	private String emailAddress;
	
	@NotBlank(message = "Phone number cannot be blank")
	@SafeHtml(whitelistType = SafeHtml.WhiteListType.NONE, message = "No HTML/JavaScript allowed")
	@Pattern(regexp = "\\d{3}-\\d{3}-\\d{4}", message = "Please enter a valid phone number: XXX-XXX-XXXX")
	private String phoneNumber;
	
	@SafeHtml(whitelistType = SafeHtml.WhiteListType.NONE, message = "No HTML/JavaScript allowed")
	@Size(max = 500, message = "Message cannot be longer than {max} characters")
	private String message;
	
	@NotEmpty(message = "Please choose a model")
	private String model;
	
	public Contact() {

	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public String getModel() {
		return model;
	}
	
	public String getFullName() {
		return this.firstName + " " + this.lastName;
	}
}