package circulation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@ComponentScan(basePackages = {"circulation"})
@EnableAspectJAutoProxy(exposeProxy = true)
@Configuration
public class MainConfig {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
		InstanceA instanceA = (InstanceA) context.getBean("instanceA");
		int add = instanceA.add(1, 2);
		System.out.println(add);
		System.out.println(instanceA.instanceB);
	}
}
