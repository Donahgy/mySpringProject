package cn.tulingxueyuan.event;

import org.springframework.context.ApplicationEvent;


@SuppressWarnings("serial")
public class OrderEvent extends ApplicationEvent{

	private String name;
	/**
	 * Create a new {@code ApplicationEvent}.
	 *
	 * @param source the object on which the event initially occurred or with
	 *               which the event is associated (never {@code null})
	 */
	public OrderEvent(Object source,String name) {
		super(source);
		this.name = name;
	}

	public String getName()
	{
		return name;
	}
}
