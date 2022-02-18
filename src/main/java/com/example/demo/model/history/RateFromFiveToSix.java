package com.example.demo.model.history;

public class RateFromFiveToSix extends BaseHandler{

	private final int RATE_MIN = 5;
	private final int RATE_MAX = 6;
	
	@Override
	public int handle(int rate) {
		if (rate >= RATE_MIN && rate <= RATE_MAX) {
			return 10;
		}
		return super.handle(rate);
	}
}
