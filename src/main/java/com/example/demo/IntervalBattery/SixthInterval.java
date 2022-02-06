package com.example.demo.IntervalBattery;

public class SixthInterval extends BaseHandler{

	private final int min = 5000;
	private final int max = 5999;
	
	@Override
	public int handle(Long battery) {
		if (battery>=min && battery<=max) {
			return 30;
		}
		return super.handle(battery);
	}
	
}
