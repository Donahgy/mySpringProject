package event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class MainClass {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
		EmailService emailService = context.getBean(EmailService.class);
		List<String> emails = new ArrayList<>();
		emails.add("aaa@qq.com");
		emails.add("bbb@qq.com");
		emails.add("ccc@qq.com");
		emailService.setBlockedList(emails);
		System.out.println("----------------");
		emailService.sendEmail("aaa@qq.com","潘东");
		emailService.sendEmail("bbb@qq.com","郇冲");
		emailService.sendEmail("aaa@qq.com","李源杰");
		System.out.println("+++++++++++++++++");
	}
}
