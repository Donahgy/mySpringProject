package cn.tulingxueyuan.event;

import org.springframework.context.SmartLifecycle;

public class MyLifecycle implements SmartLifecycle {

	private boolean started = false;

	@Override
	public void start() {
		System.err.println("MyLifecycle starting");
		started = true;
	}

	@Override
	public void stop() {
		System.err.println("MyLifecycle stopping");
		started = false;
	}

	@Override
	public boolean isRunning() {
		return started;
	}

	@Override
	public boolean isAutoStartup() {
		return true;
	}

	@Override
	public void stop(Runnable callback) {
		System.out.println("stop callback");
	}

	@Override
	public int getPhase() {
		return 0;
	}
}
