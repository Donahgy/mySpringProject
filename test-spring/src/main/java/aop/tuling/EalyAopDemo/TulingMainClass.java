package aop.tuling.EalyAopDemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import aop.tuling.Calculate;

public class TulingMainClass {


	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(EalyAopMainConfig.class);
		Calculate calculateProxy = ctx.getBean("calculateProxy", Calculate.class);
		System.out.println(calculateProxy.getClass());
		calculateProxy.div(1,1);
	}
}
