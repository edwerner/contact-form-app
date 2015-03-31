package com.contact.form.app.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.contact.form.app.domain.Contact;

@Repository
@Transactional
public class ContactDaoImpl implements ContactDao {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addContact(Contact contact) {
		this.sessionFactory.getCurrentSession().save(contact);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public java.util.List<Contact> listContacts() {
		return this.sessionFactory.getCurrentSession().createQuery("from Contact").list();
	}

	@Override
	public Contact listContactById(String id) {
		final Long longId = Long.valueOf(id);
		return (Contact) this.sessionFactory.getCurrentSession().get(Contact.class, longId); 
	}

	@Override
	public int deleteContactById(String id) {
		final Long longId = Long.valueOf(id);
		return this.sessionFactory.getCurrentSession().createQuery("delete Contact where id = :id ").setLong("id", longId).executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Contact> listContactMessages() {
		return this.sessionFactory.getCurrentSession().createQuery("select message from Contact").list();
	}
}