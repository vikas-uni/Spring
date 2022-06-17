package lifecycle.byannotation;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("lifecycle/byannotation/beans.xml");
		Employee emp = (Employee) ctx.getBean("emp");
		emp.print();
		// shutdown the context
		ctx.close();
		emp.print();
	}

}
