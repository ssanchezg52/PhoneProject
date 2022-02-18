package com.example.demo.IntervalBattery;

public class FifthInterval extends BaseHandler{
	
	private final int min = 4000;
	private final int max = 4999;
	
	@Override
	public int handle(Long battery) {
		if (battery>=min && battery<=max) {
			return 25;
		}
		return super.handle(battery);
	}

}
