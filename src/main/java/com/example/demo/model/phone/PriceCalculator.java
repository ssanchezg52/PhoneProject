package com.example.demo.model.phone;

import com.example.demo.utiles.Utiles;

public class PriceCalculator {
	
	private Float ram;
	private Processor processor;
	private Float screen;
	private Long battery;
	private final int MULTIPLIER = 2;

	public PriceCalculator(Float ram, Processor processor, Float screen, Long batery) {
		super();
		this.ram = ram;
		this.processor = processor;
		this.screen = screen;
		this.battery = batery;
	}

	public Float calculatePrize() {
		BatteryPercentageCalculator batteryPercentageCalculator = new BatteryPercentageCalculator(battery);
		int concretePercentage = batteryPercentageCalculator.calculatePercentageBatery();
		float capacity = ram + ram;
		float result = (Float.valueOf(this.processor.calculateResult()) + capacity) * Float.valueOf(this.screen);
		result += (result * concretePercentage) / 100;
		result *= MULTIPLIER;
		return Utiles.convertNumberTwoDecimals(result);
	}

	

}
