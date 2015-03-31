package com.contact.form.app.dao;

import java.util.List;

import com.contact.form.app.domain.Contact;

public interface ContactDao {
    public void addContact(Contact contact);
    public List<Contact> listContacts();
    public Contact listContactById(String id);
	public int deleteContactById(String id);
	public List<Contact> listContactMessages();
}