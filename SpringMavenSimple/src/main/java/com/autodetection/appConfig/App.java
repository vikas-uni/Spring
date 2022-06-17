package com.autodetection.appConfig;

import java.io.File;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context
	     = new AnnotationConfigApplicationContext();
		context.register(AppConfig.class);
		context.refresh();
		
		Customer cust = (Customer) context.getBean("customer");
		System.out.println(cust);
		System.out.println("Action "+cust.getAction());
		System.out.println("Person "+cust.getPerson().getName());
			}
}