package com.example.IntervalBattery;

import com.example.model.phone.Battery;

public interface Handler {

	public void setNext(Handler handler);
	public int handle(Battery request);
}
