package com.example.demo.model.history;

public interface Handler {

	public void setNext(Handler handler);
	public int handle(int rate);
}
