package com.pandong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MainStart {

	private static Map<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

	// 一级缓存
	public static Map<String,Object> singletonObjects = new ConcurrentHashMap<>();

	// 二级缓存：为了将成熟bean和纯净的bean分离开来，避免了读取到不完整的bean
	public static Map<String,Object> earlySingletonObjects = new ConcurrentHashMap<>();

	// 三级缓存


	public static void loadBeanFactory()
	{
		RootBeanDefinition aBeanDefinition = new RootBeanDefinition(InstanceA.class);
		RootBeanDefinition bBeanDefinition = new RootBeanDefinition(InstanceB.class);
		beanDefinitionMap.put("instanceA",aBeanDefinition);
		beanDefinitionMap.put("instanceB",bBeanDefinition);
	}

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		loadBeanFactory();
		for (String key : beanDefinitionMap.keySet()) {
			getBean(key);
		}

	}

	public static Object getBean(String beanName) throws InstantiationException, IllegalAccessException {

		if (getSingleton(beanName) != null)
		{
			return getSingleton(beanName);
		}

		RootBeanDefinition beanDefinition = (RootBeanDefinition) beanDefinitionMap.get(beanName);
		Class<?> beanClass = beanDefinition.getBeanClass();
		Object instanceBean = beanClass.newInstance();

		// 添加到二级缓存
		earlySingletonObjects.put(beanName,instanceBean);
		Field[] declaredFields = beanClass.getDeclaredFields();
		for (Field declaredField : declaredFields) {
			Autowired annotation = declaredField.getAnnotation(Autowired.class);
			if (annotation != null)
			{
				declaredField.setAccessible(true);
				String name = declaredField.getName();
				Object filedB = declaredField.get(name);
				declaredField.set(instanceBean,filedB);
			}
		}
		// 初始化 init-method

		// 添加到一级缓存
		singletonObjects.put(beanName,instanceBean);
		return instanceBean;
	}

	private static Object getSingleton(String beanName) {
		if (singletonObjects.containsKey(beanName))
		{
			return singletonObjects.get(beanName);
		}
		else if (earlySingletonObjects.containsKey(beanName))
		{
			return earlySingletonObjects.get(beanName);
		}
		else
		{
			return null;
		}
	}
}
