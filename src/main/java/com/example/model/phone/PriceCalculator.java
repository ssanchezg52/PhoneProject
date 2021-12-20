package com.example.model.phone;

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

	public float calculatePrize() {
		BatteryPercentageCalculator batteryPercentageCalculator = new BatteryPercentageCalculator(battery);
		int concretePercentage = batteryPercentageCalculator.calculatePercentageBatery();
		float capacity = this.ram.getCapacity() + this.ram.getCapacity();
		float result = (this.processor.calculateResult() + capacity) * this.screen.getScreenSize();
		result += (result * concretePercentage) / 100;
		return result * MULTIPLIER;
	}

}
