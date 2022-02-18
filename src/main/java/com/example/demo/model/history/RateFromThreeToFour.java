package com.example.demo.model.history;

public class RateFromThreeToFour extends BaseHandler {
	
	private final int RATE_MIN = 3;
	private final int RATE_MAX = 4;
	
	@Override
	public int handle(int rate) {
		if (rate >= RATE_MIN && rate <= RATE_MAX) {
			return 20;
		}
		return super.handle(rate);
	}

}
