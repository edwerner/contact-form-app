package com.contact.form.app.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.contact.form.app.dao.ContactDao;
import com.contact.form.app.domain.Contact;

@Service
public class ContactService {
	
	@Autowired 
	ContactDao contactDao;
	
	public void addContact(Contact contact) {
		contactDao.addContact(contact);
	}

	public List<Contact> listContacts() {
		return contactDao.listContacts();
	}

	public Contact listContactById(String id) {
		return contactDao.listContactById(id);
	}
	
	public int deleteContactById(String id) {
		return contactDao.deleteContactById(id);
	}

	public List<Contact> listContactMessages() {
		return contactDao.listContactMessages();
	}
}