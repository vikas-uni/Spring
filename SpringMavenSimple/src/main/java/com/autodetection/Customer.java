package com.autodetection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class Customer {

	@Autowired(required=true)
	private Person person;
	private int type;
	private String action;

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	@Override
	public String toString() {
		return "Customer [person = " + person + ", type=" + type + ", action="
				+ action + "]";
	}

		
}