package cn.tulingxueyuan.beans;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("cn.tulingxueyuan")
public class MainStat {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainStat.class);
		UserServiceImpl userService = applicationContext.getBean(UserServiceImpl.class);
		userService.sayHello();
	}
}
