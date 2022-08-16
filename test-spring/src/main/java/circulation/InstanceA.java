package circulation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InstanceA {

	@Autowired
	InstanceB instanceB;

	public int add(int num1,int num2)
	{
		System.out.println("执行目标方法:add");
		return num1 + num2;
	}
}
