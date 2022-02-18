package com.example.demo.model.history;

public class RateFromSevenToEight extends BaseHandler {
	
	private final int RATE_MIN = 7;
	private final int RATE_MAX = 8;
	
	@Override
	public int handle(int rate) {
		if (rate >= RATE_MIN && rate <= RATE_MAX) {
			return 5;
		}
		return super.handle(rate);
	}

}
