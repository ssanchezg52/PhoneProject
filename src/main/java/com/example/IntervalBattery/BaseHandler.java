package com.example.IntervalBattery;

import com.example.model.phone.Battery;

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
	public int handle(Battery request) {
		if(next!=null) {
			return next.handle(request);
		}
		return 0;
	}
}
