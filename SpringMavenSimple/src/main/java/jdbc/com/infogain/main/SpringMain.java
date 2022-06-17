package jdbc.com.infogain.main;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
/*
 * 
 * Employee.sql
	CREATE TABLE Employee (
  	id int not null,
  	name varchar(20) DEFAULT null,
  	role varchar(20) DEFAULT null,
  	PRIMARY KEY (id)
	);
	
 * 
 */
import java.util.List;
import java.util.Random;

import jdbc.com.infogain.jdbc.DataAccess;
import jdbc.com.infogain.model.Employee;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {
	public static void main(String[] args) throws IOException {
		File f = new File("src/main/java/jdbc/spring.xml");
		System.out.println("path is----"+f.getCanonicalPath()+f.exists());
		
		
	ApplicationContext ctx = new ClassPathXmlApplicationContext("jdbc/com/infogain/main/spring.xml");	
				//To use JdbcTemplate
	DataAccess employeeDAO = (DataAccess) ctx.getBean("empDao", DataAccess.class);
	Employee emp = new Employee();
		emp.setId(104);
       emp.setName("Rahul Yadav");
        emp.setRole("Tester");
        employeeDAO.save(emp);

        List<Employee> empList = employeeDAO.getAll();
		System.out.println("****List of Employee******");
		   for(Employee e:empList)  
	       System.out.println(e);  

/*Iterator<Employee> itr=empList.iterator();
while (itr.hasNext())
{
	Employee e1=itr.next();
	System.out.println(e1);
}*/
		   employeeDAO.delete(104);
		   
		   List<Employee> empList2 = employeeDAO.getAll();
			System.out.println("****List of Employee******");
			   for(Employee e:empList2)  
		       System.out.println(e);  
		System.out.println("*******DONE*******");
	}
}
