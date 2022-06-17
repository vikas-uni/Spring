package com.bean;

import java.util.Scanner;

public class SimpleCalc {
 int n1,n2;
 
 
 
 public SimpleCalc() {
	super();
}



public SimpleCalc(int n1, int n2) {
	super();
	this.n1 = n1;
	this.n2 = n2;
}



public void getCalc(){
	Scanner sc = new Scanner(System.in);
	System.out.println("enter n1");
	this.n1 = sc.nextInt();
	System.out.println("enter n2");
	this.n2 = sc.nextInt();
	
	 //SimpleCalc calc
 }


public void printSum(){
	System.out.println("Sum is:"+(this.n1+this.n2));
}

}
