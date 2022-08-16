package circulation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Order
@Component
public class MyPointCutClass {

	@Pointcut("execution(* circulation.InstanceA..*(..))")
	public void pointCut(){};

	@Before(value = "pointCut()")
	public void beforeJoinPoint(JoinPoint joinPoint)
	{
		String name = joinPoint.getSignature().getName();
		System.out.println("执行目标方法【"+name+"】的<前置通知>,入参"+ Arrays.asList(joinPoint.getArgs()));
	}

	@After(value = "pointCut()")
	public void afterJoinPoint(JoinPoint joinPoint)
	{
		String name = joinPoint.getSignature().getName();
		System.out.println("执行目标方法【"+name+"】的<后置通知>,入参"+Arrays.asList(joinPoint.getArgs()));
	}
}
