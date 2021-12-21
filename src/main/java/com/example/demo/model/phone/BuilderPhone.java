package com.example.demo.model.phone;

import com.example.demo.utiles.Utiles;

public class BuilderPhone {
	private Brand brand;
	private Model model;
	private Processor processor;
	private Ram ram;
	private Screen screen;
	private Battery batery;
	private long antutu;
	private String prize;
	private final int MIN_CORE = 1;
	private final int MAX_CORE = 8;
	private final int MIN_SCREEN = 4;
	private final int MAX_SCREEN = 7;
	private final String CURRENCY_TYPE = "€";
	
	public BuilderPhone(Brand brand, Model model) {
		super();
		this.brand = brand;
		this.model = model;
		this.processor = new Processor(Utiles.getRandomWholeNumber(MIN_CORE, MAX_CORE));
		this.ram = new Ram(this.processor.getCoreNumber());
		this.screen = new Screen(Utiles.getRandomDecimalNumber(MIN_SCREEN, MAX_SCREEN));
		this.batery = new Battery(this.processor, this.screen);
		this.antutu = CalculatorAntutu.calculateAntutu(this.processor, this.ram);
		PriceCalculator prizeCalculator = new PriceCalculator(this.ram, this.processor, this.screen, this.batery);
		this.prize = prizeCalculator.calculatePrize()+CURRENCY_TYPE;
	}
	
	public Phone builder() {
		return new Phone(this);
	}

	public Brand getBrand() {
		return brand;
	}

	public Model getModel() {
		return model;
	}

	public Processor getProcessor() {
		return processor;
	}

	public Ram getRam() {
		return ram;
	}

	public Screen getScreen() {
		return screen;
	}

	public Battery getBatery() {
		return batery;
	}
	
	public long getAntutu() {
		return antutu;
	}

	public String getPrize() {
		return prize;
	}
}
