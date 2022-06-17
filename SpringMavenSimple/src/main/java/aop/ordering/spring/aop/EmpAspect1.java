package aop.ordering.spring.aop;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
@Aspect
@Order(value=0)
public class EmpAspect1 {
	@Before("execution(* aop.ordering.spring.service.EmployeeService.addEmployee(..))")
	public void myAdvice()
	{
		System.out.println("******Before Advice to be applied first*******");
	}
}
