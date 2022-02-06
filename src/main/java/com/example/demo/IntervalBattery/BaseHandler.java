package com.example.demo.IntervalBattery;

public abstract class BaseHandler implements Handler {
	Handler next;

	public BaseHandler() {
		super();
	}

	@Override
	public void setNext(Handler handler) {
		next=handler;
	}
	@Override
	public int handle(Long battery) {
		if(next!=null) {
			return next.handle(battery);
		}
		return 0;
	}
}
