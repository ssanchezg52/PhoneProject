package com.example.demo.IntervalBattery;

public class SeventhInterval extends BaseHandler {
	
	private final int min = 6000;
	private final int max = 6999;
	
	@Override
	public int handle(Long battery) {
		if (battery>=min && battery<=max) {
			return 35;
		}
		return super.handle(battery);
	}

}
