package com.autodetection;

import java.io.File;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		//System.out.println(new File("classpath*:abc").getAbsolutePath());
		
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("com/autodetection/beans.xml");

		Customer cust = (Customer) context.getBean("customer");
		System.out.println(cust);
		System.out.println("Action "+cust.getAction());
		System.out.println("Person "+cust.getPerson().getName());
			}
}