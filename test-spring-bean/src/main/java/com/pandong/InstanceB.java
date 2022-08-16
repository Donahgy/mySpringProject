package com.pandong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;

@Component
//@Scope("prototype")
public class InstanceB {

	@Autowired
	InstanceA instanceA;

	public InstanceA getInstanceA() {
		return instanceA;
	}


	public void setInstanceA(InstanceA instanceA) {
		this.instanceA = instanceA;
	}

	public InstanceB(InstanceA instanceA) {
		this.instanceA = instanceA;
	}


	public InstanceB() {
		System.out.println("InstanceB实例化");
	}
}
