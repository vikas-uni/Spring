package com.beans.byconstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class TestAutoWire {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/beans/byconstructor/spring.xml");
          EmployeeBean employee = (EmployeeBean)context.getBean("employee");
          System.out.println(employee.getFullName());
          System.out.println(employee.getDepartmentBean().getName());

	}

}
