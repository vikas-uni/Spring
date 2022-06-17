package aop.ordering.spring.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("aop/ordering/spring/service/spring.xml");
		EmployeeService s=(EmployeeService)ctx.getBean("empservimpl");
		s.addEmployee();
		
	}
}
