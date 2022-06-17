package com.javacodegeeks.snippets.enterprise;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;
/*
 * The HelloWorldController extends the AbstractController provided by Spring, and overrides the handleRequestInternal(HttpServletRequest request,
 *  HttpServletResponse response) method, where a org.springframework.web.servlet.ModelAndView is created by a handler and returned to be resolved by the DispatcherServlet
 */

public class HelloWorldController extends AbstractController{

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		ModelAndView model = new ModelAndView("helloWorld");
		model.addObject("msg", "hello world!");
		
		return model;
	}

	
		
	}