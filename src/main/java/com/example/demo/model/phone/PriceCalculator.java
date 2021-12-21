package com.example.demo.model.phone;

import java.text.DecimalFormat;

public class PriceCalculator {
	
	private Ram ram;
	private Processor processor;
	private Screen screen;
	private Battery battery;
	private final int MULTIPLIER = 2;

	public PriceCalculator(Ram ram, Processor processor, Screen screen, Battery batery) {
		super();
		this.ram = ram;
		this.processor = processor;
		this.screen = screen;
		this.battery = batery;
	}

	public String calculatePrize() {
		BatteryPercentageCalculator batteryPercentageCalculator = new BatteryPercentageCalculator(battery);
		int concretePercentage = batteryPercentageCalculator.calculatePercentageBatery();
		float capacity = ram.getCapacity() + ram.getCapacity();
		float result = (Float.valueOf(this.processor.calculateResult()) + capacity) * Float.valueOf(this.screen.getScreenSize());
		result += (result * concretePercentage) / 100;
		result *= MULTIPLIER;
		return convertNumberTwoDecimals(result);
	}

	private String convertNumberTwoDecimals(float result) {
		DecimalFormat decimalFormat = new DecimalFormat("#.##");
		String format = decimalFormat.format(result);
		return format.replace(",", ".");
	}

}
