package com.pandong.component;

import com.pandong.entity.User;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

@SuppressWarnings({"rawtypes","unchecked"})
public class MyFactoryBean<T> implements FactoryBean<T> {

	private Class<T> mapperInterFace;

	public Class<T> getMapperInterFace() {
		return mapperInterFace;
	}

	public void setMapperInterFace(Class<T> mapperInterFace) {
		this.mapperInterFace = mapperInterFace;
	}

	// 动态传进来


	@Override
	public T getObject() throws Exception {
		InvocationHandler handler =(proxy, method, args1) -> {
			// 查询数据库...   mybatis
			System.out.println("查询");
			return new User();
		};
		// DeptMapper
		return (T) Proxy.newProxyInstance(mapperInterFace.getClassLoader(),
				new Class[]{mapperInterFace}, handler);
	}

	@Override
	public Class<?> getObjectType() {
		return mapperInterFace;
	}

	public MyFactoryBean() {
		System.out.println("加载");
	}
}
