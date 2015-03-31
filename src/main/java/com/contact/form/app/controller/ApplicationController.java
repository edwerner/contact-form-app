package com.contact.form.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ApplicationController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView listContacts(ModelMap model) {
		String title = "Contact-Car Data Service";
		model.addAttribute("title", title);
		return new ModelAndView("index", model);
	}
}