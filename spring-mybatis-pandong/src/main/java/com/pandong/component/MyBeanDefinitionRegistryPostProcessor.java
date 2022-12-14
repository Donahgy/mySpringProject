package com.pandong.component;

import com.pandong.mapper.UserMapper;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor {
	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		// 并不是直接注册动态代理， 而是注册FactoryBean

		// 扫描所有mapper接口{   所有mapper接口类
		GenericBeanDefinition beanDefinition=new GenericBeanDefinition();
		beanDefinition.setBeanClass(MyFactoryBean.class);

		beanDefinition.getPropertyValues().addPropertyValue("mapperInterFace", UserMapper.class);

		registry.registerBeanDefinition("userMapper2",beanDefinition);

	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

	}
}
