package factoryMethod.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import factoryMethod.model.*;

public class TestApp {

	public static void main(String[] args) {
		
        ApplicationContext context = new ClassPathXmlApplicationContext("factoryMethod/model/spring.xml");
        
        Employee manager = (Employee) context.getBean("manager");
        System.out.println(manager);
         
        Employee director = (Employee) context.getBean("director");
        System.out.println(director);

	}

}
