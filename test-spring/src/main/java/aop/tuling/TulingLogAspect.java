package aop.tuling;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import aop.tuling.tuling.Introductions.ProgramCalculate;
import aop.tuling.tuling.Introductions.SimpleProgramCalculate;

import java.util.Arrays;

@Aspect
@Order
@Component
public class TulingLogAspect {

//	@DeclareParents(value = "tuling.TulingCalculate",defaultImpl = SimpleProgramCalculate.class)
//	public ProgramCalculate programCalculate;

	@Pointcut("execution(* aop.tuling.TulingCalculate.*(..))")
	public void pointCut(){};

	@Before(value = "pointCut()")
	public void methodBefore(JoinPoint joinPoint)
	{
		String name = joinPoint.getSignature().getName();
		System.out.println("执行目标方法【"+name+"】的<前置通知>,入参"+ Arrays.asList(joinPoint.getArgs()));
	}

	@After(value = "pointCut()")
	public void methodAfter(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("执行目标方法【"+methodName+"】的<后置通知>,入参"+Arrays.asList(joinPoint.getArgs()));
	}

	@AfterReturning(value = "pointCut()",returning = "result")
	public void methodReturning(JoinPoint joinPoint, Object result) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("执行目标方法【"+methodName+"】的<返回通知>,入参"+Arrays.asList(joinPoint.getArgs()));
	}

	@AfterThrowing(value = "pointCut()")
	public void methodAfterThrowing(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		System.out.println("执行目标方法【"+methodName+"】的<异常通知>,入参"+Arrays.asList(joinPoint.getArgs()));
	}
}
