package aop.annotation;

public class EmployeeServiceImpl implements EmployeeService{

	public void getEmployeebyNameAndId(int id, String name) {
	System.out.println("*****getEmployeebyNameAndId actual method ****");
		System.out.println("Emp Id "+id+" Name is "+name);
	}
	
	public void addEmployee() {
		System.out.println("One Employee Is addeded");
	}
	
	}


