package com.example.demo.IntervalBattery;

public interface Handler {

	public void setNext(Handler handler);
	public int handle(Long request);
}
