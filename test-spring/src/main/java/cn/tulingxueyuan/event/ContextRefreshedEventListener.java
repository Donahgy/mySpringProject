package cn.tulingxueyuan.event;

import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class ContextRefreshedEventListener {

	@Async
	@EventListener(ContextRefreshedEvent.class)
	public void onApplication(ContextRefreshedEvent event)
	{
		if (event.getApplicationContext().getParent() == null)
		{
			System.out.println("______________\n容器加载完毕\n———————");
		}
	}
}
