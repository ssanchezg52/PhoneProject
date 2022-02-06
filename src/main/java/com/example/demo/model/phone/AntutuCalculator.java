package com.example.demo.model.phone;

public class AntutuCalculator{
	
	private static final int MULTIPLIER = 12000;

	public static Long calculateAntutu(Processor processor, Float ram) {
		float capacity =  ram + ram;
		return (long) ((processor.calculateResult() + capacity) * MULTIPLIER);
	}

}
