package com.example.demo.model.history;

public class RateFromZeroToTwo extends BaseHandler {
	
	private final int RATE_MIN = 0;
	private final int RATE_MAX = 2;
	
	@Override
	public int handle(int rate) {
		if (rate >= RATE_MIN && rate <= RATE_MAX) {
			return 30;
		}
		return super.handle(rate);
	}

}
