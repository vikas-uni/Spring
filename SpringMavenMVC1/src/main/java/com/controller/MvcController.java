package com.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/* @RequestMapping can be applied on class level or method generally it is applied on method level in case when controller has
 multiple handler method for narrowing the request mapping.
 */
@Controller
// @Component
@RequestMapping("/hello")
public class MvcController {
	@RequestMapping(value = {"/get","/fetch"}, method = RequestMethod.GET)
	public ModelAndView get() {
		// return new ModelAndView("hello","msg","welcome to spring");
		ModelAndView model = new ModelAndView("hello");
		model.addObject("msg", "Welcome");
		return model;
	}

	@RequestMapping("/hello")
	public String my(ModelMap map) {
		map.addAttribute("name", "Mohit");
		map.addAttribute("date", new Date());

		return "abc";
	}
}
