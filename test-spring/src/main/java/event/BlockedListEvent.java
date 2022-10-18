package event;

import org.springframework.context.ApplicationEvent;

import java.io.Serializable;

public class BlockedListEvent extends ApplicationEvent implements Serializable {

	private static final long serialVersionUID = 1L;

	private String address;
	private String content;

	/**
	 * Create a new {@code ApplicationEvent}.
	 *
	 * @param source the object on which the event initially occurred or with
	 *               which the event is associated (never {@code null})
	 */
	public BlockedListEvent(Object source,String address,String content) {
		super(source);
		this.address = address;
		this.content = content;
	}

	public String getAddress() {
		return address;
	}

	public String getContent() {
		return content;
	}
}
