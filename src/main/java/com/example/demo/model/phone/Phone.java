	package com.example.demo.model.phone;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.example.demo.model.history.HistoricalPrice;
import com.example.demo.utiles.Utiles;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Phone {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String brand;
	private String model;
	@Embedded
	@Column(nullable = false)
	private Processor processor;
	@Column(nullable = false)
	private Float ram;
	@Column(nullable = false)
	private Float screen;
	@Column(nullable = false)
	private Long battery;
	@Column(nullable = false)
	private Long antutu;
	@Column(nullable = false)
	private Float price;
	@OneToMany(mappedBy = "phone")
	private List<HistoricalPrice> priceHistory;
	public static class BuilderPhone {
		private String brand;
		private String model;
		private Processor processor;
		private Float ram;
		private Float screen;
		private Long batery;
		private Long antutu;
		private Float price;
		private final int MIN_CORE = 1;
		private final int MAX_CORE = 8;
		private final int MIN_SCREEN = 4;
		private final int MAX_SCREEN = 7;
		
		public BuilderPhone(String brand, String model) {
			super();
			this.brand = brand;
			this.model = model;
			this.processor = new Processor(Utiles.getRandomWholeNumber(MIN_CORE, MAX_CORE));
			this.ram = RamCalculator.calculateCapacity(this.processor.getCoreNumber());
			this.screen = Utiles.convertNumberTwoDecimals(Utiles.getRandomDecimalNumber(MIN_SCREEN, MAX_SCREEN));
			this.batery = BatteryCalculator.calculateBatery(this.processor, this.screen);
			this.antutu = AntutuCalculator.calculateAntutu(this.processor, this.ram);
			PriceCalculator prizeCalculator = new PriceCalculator(this.ram, this.processor, this.screen, this.batery);
			this.price = prizeCalculator.calculatePrize();
		}
		
		public Phone builder() {
			return new Phone(this);
		}

		public String getBrand() {
			return brand;
		}

		public String getModel() {
			return model;
		}

		public Processor getProcessor() {
			return processor;
		}

		public Float getRam() {
			return ram;
		}

		public Float getScreen() {
			return screen;
		}

		public Long getBatery() {
			return batery;
		}
		
		public Long getAntutu() {
			return antutu;
		}

		public Float getPrize() {
			return price;
		}
	}
	
	public Phone(BuilderPhone builderPhone) {
		this.brand = builderPhone.getBrand();
		this.model = builderPhone.getModel();
		this.processor = builderPhone.getProcessor();
		this.ram = builderPhone.getRam();
		this.screen = builderPhone.getScreen();
		this.battery = builderPhone.getBatery();
		this.antutu = builderPhone.getAntutu();
		this.price = builderPhone.getPrize();
	}

	public Phone() {
		super();
	}
	
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
	
	public Long getBattery() {
		return battery;
	}

	public void setBatery(Long batery) {
		this.battery = batery;
	}

	public Long getAntutu() {
		return antutu;
	}

	public void setAntutu(Long antutu) {
		this.antutu = antutu;
	}

	public Float getPrice() {
		return this.price;
	}
	
	public void setPrice(Float price) {
		this.price = price;
	}	
	
	public List<HistoricalPrice> getPriceHistory() {
		return priceHistory;
	}
	
	public void setPriceHistory(List<HistoricalPrice> priceHistory) {
		this.priceHistory = priceHistory;
	}

	@Override
	public int hashCode() {
		return Objects.hash(antutu, battery, brand, id, model, price, processor, ram, screen);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Phone other = (Phone) obj;
		return antutu == other.antutu && Objects.equals(battery, other.battery) && Objects.equals(brand, other.brand)
				&& id == other.id && Objects.equals(model, other.model) && Objects.equals(price, other.price)
				&& Objects.equals(processor, other.processor) && Objects.equals(ram, other.ram)
				&& Objects.equals(screen, other.screen);
	}

	@Override
	public String toString() {
		return "Phone [id=" + id + ", brand=" + brand + ", model=" + model + ", processor=" + processor + ", ram=" + ram
				+ ", screen=" + screen + ", batery=" + battery + ", antutu=" + antutu + ", prize=" + price + "]";
	}
	
}
