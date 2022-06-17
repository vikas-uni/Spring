package com.infogain.controller;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.infogain.form.Contact;
@Controller
public class ContactController
{
	@RequestMapping("/contacts")
	public ModelAndView showContacts() {
	return new ModelAndView("contact", "command", new Contact());
	}
	@RequestMapping(value = "/addContact", method = RequestMethod.POST)
	public String addContact(@ModelAttribute("contact")
							Contact contact) {
		System.out.println("First Name: " + contact.getFirstname() + 
					" Last Name: " + contact.getLastname());
					return "disp";
	}
}
