package com.example.demo.IntervalBattery;

public class FirstInterval extends BaseHandler {
	
	private final int min = 0;
	private final int max =999;
	
	@Override
	public int handle(Long battery) {
		if (battery >= min && battery<=max) {
			return 5;
		}
		return super.handle(battery);
	}

}
