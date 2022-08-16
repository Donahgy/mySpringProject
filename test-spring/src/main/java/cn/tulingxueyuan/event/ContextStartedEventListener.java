package cn.tulingxueyuan.event;

import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ContextStartedEventListener {

	@EventListener(ContextStartedEvent.class)
	public void onApplicationEvent(ContextStartedEvent event)
	{
		if (event.getApplicationContext().getParent() == null)
		{
			System.out.println("\n\n\n\n\n______________\n\n\n启动了\n\n_________\n\n");
		}
	}
}
