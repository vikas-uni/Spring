package aop.annotation;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/*
 * Aspect
An Aspect is the concern (cross cutting concern) which you want to implement in the application such as logging, performance monitoring, transactional handing etc.

Advice
An Advice is the actual implementation of the aspect. Aspect is a concept and Advice is the concrete implementation of the concept.

Join Point
A JoinPoint is a point in the execution of the program where an aspect can be applied. It could be before/after executing the method, before throwing an exception, 
before/after modifying an instance variable etc. Keep in mind that it is not necessary and also not required to apply an aspect at all the available join points. 
Spring AOP only supports method execution join points.

Point cut
 A pointcut defines what advices are required at what join points.So a pointcut informs to the IOC container that what business methods of a class needs what type of services.
PointCuts tell on which join points the aspect will be applied. An advice is associated with a point cut expression and is applied to a join point which matches the point cut expression.

Target
Target is the application object on which the advice will be applied.

Proxy
Proxy is the object which is created by the framework after applying the advice on the target object.

Weaving
Weaving is the process of applying the aspect on the target object to product the proxy object. Weaving can be done at compile time, class loading time or runtime. 
Spring AOP supports weaving at runtime.

Introduction
An Introduction enables to add new methods and instances to the target object.
 */


@Aspect
public class EmployeeAspect {
	// declare method based pointcut
@Pointcut ("execution(* aop.annotation.EmployeeService.addEmployee(..))")
public void addEmpPointcut(){
	
	System.out.println("in emp pointcut...");
}
		
		//call1. @Before is an advice which executes before a joinPoint(method)
@Before("execution(* aop.annotation.EmployeeService.getEmployeebyNameAndId(..))")
		// Secondary concern
		public void myBeforeAdvice(JoinPoint jpoint) //Advice Method
		{
	System.out.println("Inside Befor Advice Method...");
	System.out.println("Write your secondry bussiness logic before execution of JoinPoint");
 System.out.println("Entering inside Method "+jpoint.getSignature().getName());	
 System.out.println("Method "+Arrays.toString(jpoint.getArgs()));
 System.out.println("Target class "+jpoint.getTarget().getClass().getName());
		}
	

       //call2
		@After("addEmpPointcut()")
		
		public void afterAdvice()// Advice Method
		{
			System.out.println("Inside After Advice...");
			System.out.println("Write your secondry bussiness logic after execution of JoinPoint");
		}
		
}
