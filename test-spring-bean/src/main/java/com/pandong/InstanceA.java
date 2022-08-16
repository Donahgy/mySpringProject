package com.pandong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
//@Scope("singleton")
public class InstanceA {

	@Autowired
	InstanceB instanceB;

	@PostConstruct
	public void init() {
		instanceB.setInstanceA(this);
	}

	public InstanceB getInstanceB() {
		return instanceB;
	}

	public void setInstanceB(InstanceB instanceB) {
		this.instanceB = instanceB;
	}

	public InstanceA(InstanceB instanceB) {
		this.instanceB = instanceB;
	}


	public InstanceA() {
		System.out.println("InstanceA实例化");
	}
}
