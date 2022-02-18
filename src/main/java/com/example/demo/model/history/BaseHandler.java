package com.example.demo.model.history;

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
	public int handle(int rate) {
		if(next!=null) {
			return next.handle(rate);
		}
		return 0;
	}
}
