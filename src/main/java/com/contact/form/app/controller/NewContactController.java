package com.contact.form.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.contact.form.app.dao.CarDao;
import com.contact.form.app.dao.ContactDao;
import com.contact.form.app.domain.Car;
import com.contact.form.app.domain.Contact;

@Controller
@RequestMapping(value = "contacts")
public class NewContactController {

	@Autowired
	ContactDao contactDao;

	@Autowired
	CarDao carDao;

	@RequestMapping(value = "/new/index", method = RequestMethod.GET)
	public Contact contact(ModelMap model) {
		List<Car> carList = carDao.listCars();
		model.addAttribute("carChoices", carList);
		return new Contact();
	}

	@RequestMapping(value = "/new/index", method = RequestMethod.POST)
	public ModelAndView newContact(
			@Valid @ModelAttribute("contact") Contact contact,
			BindingResult result, ModelMap model) {

		contact.setModel(contact.getModel());
		System.out.println("getModel: " + contact.getModel());
		List<Car> carList = carDao.listCars();
		model.addAttribute("carChoices", carList);
		boolean matchFound = false;

		for (Car car : carList) {
			System.out.println("car.getModel(): " + car.getModel());
			System.out.println("contact.getModel(): " + contact.getModel());
			System.out.println("carList: " + carList.size());

			if (car.getModel().equals(contact.getModel())) {
				System.out.println("found a match");
				matchFound = true;
				break;
			}
		}

		if (!matchFound) {
			result.rejectValue("model", "NotEmpty.contact.model",
					new Object[] {}, "Please choose a model");
			return new ModelAndView("contacts/new/index", model);
		}

		if (result.hasErrors()) {
			return new ModelAndView("contacts/new/index", model);
		}

		contact.setFirstName(contact.getFirstName());
		contact.setLastName(contact.getLastName());
		contact.setEmailAddress(contact.getEmailAddress());
		contact.setPhoneNumber(contact.getPhoneNumber());
		contact.setMessage(contact.getMessage());
		contactDao.addContact(contact);
		return new ModelAndView("contacts/success/success");
	}
}