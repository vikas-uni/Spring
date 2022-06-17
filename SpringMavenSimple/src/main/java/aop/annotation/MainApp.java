package aop.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) {
ApplicationContext ctx=new ClassPathXmlApplicationContext("aop/annotation/applicationContext.xml");
		EmployeeService s=(EmployeeService)ctx.getBean("empservimpl");
		s.getEmployeebyNameAndId(101, "Ravic");// first
		System.out.println("------------------------------------------------");
		s.addEmployee();
			}

}
