package com.spring.bean;

public class Employee {
	private int id;
	private String name;
	private String role;
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String toString(){
		return "Eid "+id+" Name "+name+"Role "+role;
	}
}
