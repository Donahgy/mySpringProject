package aop.tuling;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TulingMainClass {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfig.class);
		Calculate calculate = (Calculate) ctx.getBean("calculate");
		int retVal = calculate.div(2,4);


//		ProgramCalculate pcalculate = (ProgramCalculate) ctx.getBean("tulingCalculate");
//		pcalculate.toBinary(100);
	}
}
