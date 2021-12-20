package com.example.IntervalBattery;

import com.example.model.phone.Battery;

public class DefaultPorcentage extends BaseHandler {
	
	@Override
	public int handle(Battery request) {
		return 3;
	}

}
