package aop.ordering.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
@Aspect
@Order(value=1)
public class EmpAspect {
@Before("execution(* aop.ordering.spring.service.EmployeeService.addEmployee(..))")
public void myBeforeAdvice(JoinPoint jpoint)
	{
	System.out.println("Before Advice to be applied second ");
	System.out.println("Method Intercepted "+jpoint.getSignature().getName());
	}
}
