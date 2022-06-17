package lifecycle.byannotation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
public class Employee {
	int eId;
	String name;
	String dept;

	public int geteId() {
		System.out.println("Inside setter....");
		return eId;
	}

	public void seteId(int eId) {
		this.eId = eId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public void print() {
		System.out.println("****Emp Details*****");
		System.out.println("Eid " + eId + " Name " + name + " Department " + dept);
	}

	public Employee() {
		System.out.println("Employee Constructor...");
	}

	@PreDestroy
	public void destroy() {
		System.out.println("Releasing Resource");
		eId = 0;
		name = null;
		dept = null;
		System.out.println("Resource Released");
	}

	@PostConstruct
	public void afterPropertiesSet() throws Exception {
		System.out.println("Initilizing Resource");
		setDept("HR");
		System.out.println("Resource Initilized");

		}
}
