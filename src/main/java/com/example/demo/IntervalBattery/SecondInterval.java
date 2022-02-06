package com.example.demo.IntervalBattery;

public class SecondInterval extends BaseHandler {
	
	private final int min = 1000;
	private final int max = 1999;

	
	@Override
	public int handle(Long battery) {
		if (battery>=min && battery<=max) {
			return 10;
		}
		return super.handle(battery);
	}
	
}
