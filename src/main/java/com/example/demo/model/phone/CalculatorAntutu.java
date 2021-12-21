package com.example.demo.model.phone;

public class CalculatorAntutu{
	
	private static final int MULTIPLIER = 12000;

	public static long calculateAntutu(Processor processor, Ram ram) {
		float capacity =  ram.getCapacity() + ram.getCapacity();
		return (long) ((processor.calculateResult() + capacity) * MULTIPLIER);
	}

}
