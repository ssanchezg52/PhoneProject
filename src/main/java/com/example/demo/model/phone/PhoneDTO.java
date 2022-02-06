package com.example.demo.model.phone;

public class PhoneDTO {
	
	private Long id;
	private String brand;
	private String model;
	private Processor processor;
	private Float ram;
	private Float screen;
	private Long batery;
	private Long antutu;
	private Float price;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Processor getProcessor() {
		return processor;
	}
	public void setProcessor(Processor processor) {
		this.processor = processor;
	}
	public Float getRam() {
		return ram;
	}
	public void setRam(Float ram) {
		this.ram = ram;
	}
	public Float getScreen() {
		return screen;
	}
	public void setScreen(Float screen) {
		this.screen = screen;
	}
	public Long getBatery() {
		return batery;
	}
	public void setBatery(Long batery) {
		this.batery = batery;
	}
	public Long getAntutu() {
		return antutu;
	}
	public void setAntutu(long antutu) {
		this.antutu = antutu;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	
}
