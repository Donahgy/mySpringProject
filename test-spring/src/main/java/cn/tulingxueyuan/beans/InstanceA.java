package cn.tulingxueyuan.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InstanceA {

	@Autowired
	InstanceB instanceB;



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
