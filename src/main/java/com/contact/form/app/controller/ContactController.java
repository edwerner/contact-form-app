package com.contact.form.app.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import com.contact.form.app.dao.ContactDao;
import com.contact.form.app.domain.Contact;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "contacts")
public class ContactController {
	
	@Autowired
	ContactDao contactDao;

	@RequestMapping(value = "/list/all", method = RequestMethod.GET)
	public ModelAndView listContacts(ModelMap model) {
		List<Contact> contactList = contactDao.listContacts();
		model.addAttribute("newContact", contactList);
		return new ModelAndView("contacts/list/all", model);
	}
	
	@RequestMapping(value = "/contactsJson", method=RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public byte[] getContacts() throws IOException {
		final List<Contact> contactMessages = contactDao.listContactMessages();
		final OutputStream out = new ByteArrayOutputStream();
		final ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(out, contactMessages);
		final byte[] contacts = ((ByteArrayOutputStream) out).toByteArray();
		return contacts;
	}
	
	@RequestMapping(value = "/list/{id}", method = RequestMethod.GET)
	public ModelAndView listIndividualUser(@PathVariable String id, ModelMap model) {
		Contact contact = contactDao.listContactById(id);
		model.addAttribute("individualContact", contact);
		return new ModelAndView("contacts/list/listById", model);
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteIndividualUser(@PathVariable String id, ModelMap model) {
		Contact deletedContact = contactDao.listContactById(id);
		model.addAttribute("deletedContact", deletedContact);
		int contactList = contactDao.deleteContactById(id);
		model.addAttribute("individualContact", contactList);
		return new ModelAndView("contacts/delete/deleteById", model);
	}
}