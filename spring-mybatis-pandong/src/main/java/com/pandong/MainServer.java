package com.pandong;

import com.pandong.config.MybatisConfig;
import com.pandong.mapper.UserMapper;
import com.pandong.serivce.TestService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainServer {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ioc = new AnnotationConfigApplicationContext(MybatisConfig.class);
//		UserMapper bean = (UserMapper) ioc.getBean("userMapper");
//		System.out.println(bean.selectById(1L));

		TestService testService = (TestService)ioc.getBean("testServiceImpl");
		testService.Test();
	}
}
