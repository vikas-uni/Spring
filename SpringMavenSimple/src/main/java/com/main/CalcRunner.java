package com.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bean.SimpleCalc;

public class CalcRunner {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/main/simple.xml");
		SimpleCalc calc = (SimpleCalc)applicationContext.getBean("calc");
		calc.getCalc();
		calc.printSum();

	}

}
