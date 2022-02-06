package com.example.demo.IntervalBattery;

public class ThirdInterval extends BaseHandler {
	
	private final int min = 2000;
	private final int max = 2999;
	
	@Override
	public int handle(Long batery) {
		if (batery>=min && batery<=max) {
			return 15;
		}
		return super.handle(batery);
	}

}
