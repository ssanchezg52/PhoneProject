package com.example.IntervalBattery;

import com.example.model.phone.Battery;

public class FirstInterval extends BaseHandler {
	
	private final int min = 0;
	private final int max =999;
	
	@Override
	public int handle(Battery batery) {
		if (batery.getMAhNumber() >= min && batery.getMAhNumber()<=max) {
			return 5;
		}
		return super.handle(batery);
	}

}
