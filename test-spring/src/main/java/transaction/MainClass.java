package transaction;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class MainClass
{
	public static void main(String[] args)
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				MainConfig.class);
		UserService userServiceImpl = (UserService)context.getBean("userServiceImpl");
		userServiceImpl.save(new User("jingzhe",25));

	}
}
