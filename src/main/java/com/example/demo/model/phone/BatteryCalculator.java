package com.example.demo.model.phone;

public class BatteryCalculator {
	
	private static final int MULTIPLIER = 190;
	
	public static Long calculateBatery(Processor processor, Float screen) {
		float result = Float.valueOf(processor.calculateResult()) + screen;
		return (long) (result * MULTIPLIER);
	}

}
