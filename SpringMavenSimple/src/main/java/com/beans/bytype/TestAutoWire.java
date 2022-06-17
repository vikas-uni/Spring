package com.beans.bytype;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class TestAutoWire {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/beans/bytype/spring.xml");
          EmployeeBean employee = (EmployeeBean)context.getBean("employee1");
      System.out.println(employee.getFullName());
      System.out.println(employee.getDepartmentBean().getName());

	}

}
