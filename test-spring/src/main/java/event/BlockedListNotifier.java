package event;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class BlockedListNotifier{

	private String notificationAddress;

	public void setNotificationAddress(String notificationAddress) {
		this.notificationAddress = notificationAddress;
	}

	@Async
	@EventListener(BlockedListEvent.class)
	public void onApplicationEvent(BlockedListEvent event) {
		System.out.println(event.getAddress() + " " + event.getContent());
	}
}
