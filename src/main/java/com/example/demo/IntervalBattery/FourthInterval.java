package com.example.demo.IntervalBattery;

public class FourthInterval extends BaseHandler{
	
	private final int min = 3000;
	private final int max = 3999;
	
	@Override
	public int handle(Long battery) {
		if (battery>=min && battery<=max) {
			return 20;
		}
		return super.handle(battery);
	}

}
