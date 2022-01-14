package com.example.demo.model.phone;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.demo.utiles.Utiles;

@Entity
public class Phone {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "brand")
	private String brand;
	@Column(name = "model")
	private String model;
	@Embedded
	@Column(nullable = false)
	private Processor processor;
	@Embedded
	@Column(nullable = false)
	private Ram ram;
	@Embedded
	@Column(nullable = false)
	private Screen screen;
	@Embedded
	@Column(nullable = false)
	private Battery batery;
	@Column(nullable = false)
	private long antutu;
	@Column(nullable = false)
	private String price;
	
	public static class BuilderPhone {
		private String brand;
		private String model;
		private Processor processor;
		private Ram ram;
		private Screen screen;
		private Battery batery;
		private long antutu;
		private String price;
		private final int MIN_CORE = 1;
		private final int MAX_CORE = 8;
		private final int MIN_SCREEN = 4;
		private final int MAX_SCREEN = 7;
		
		public BuilderPhone(String brand, String model) {
			super();
			this.brand = brand;
			this.model = model;
			this.processor = new Processor(Utiles.getRandomWholeNumber(MIN_CORE, MAX_CORE));
			this.ram = new Ram(this.processor.getCoreNumber());
			this.screen = new Screen(Utiles.getRandomDecimalNumber(MIN_SCREEN, MAX_SCREEN));
			this.batery = new Battery(this.processor, this.screen);
			this.antutu = AntutuCalculator.calculateAntutu(this.processor, this.ram);
			PriceCalculator prizeCalculator = new PriceCalculator(this.ram, this.processor, this.screen, this.batery);
			this.price = prizeCalculator.calculatePrize()+TypeUnitOfMeasure.PRECIO;
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
			return price;
		}
	}
	
	public Phone(BuilderPhone builderPhone) {
		this.brand = builderPhone.getBrand();
		this.model = builderPhone.getModel();
		this.processor = builderPhone.getProcessor();
		this.ram = builderPhone.getRam();
		this.screen = builderPhone.getScreen();
		this.batery = builderPhone.getBatery();
		this.antutu = builderPhone.getAntutu();
		this.price = builderPhone.getPrize();
	}

	public Phone() {
		super();
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
	
	public String getPrizeWithCurrencyType() {
		return this.price;
	}

	public float getPrizeWithoutCurrencyType() {
		String replace = this.price.replace("€", "");
		return Float.valueOf(replace);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(antutu, batery, brand, id, model, price, processor, ram, screen);
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
		return antutu == other.antutu && Objects.equals(batery, other.batery) && Objects.equals(brand, other.brand)
				&& id == other.id && Objects.equals(model, other.model) && Objects.equals(price, other.price)
				&& Objects.equals(processor, other.processor) && Objects.equals(ram, other.ram)
				&& Objects.equals(screen, other.screen);
	}

	@Override
	public String toString() {
		return "Phone [id=" + id + ", brand=" + brand + ", model=" + model + ", processor=" + processor + ", ram=" + ram
				+ ", screen=" + screen + ", batery=" + batery + ", antutu=" + antutu + ", prize=" + price + "]";
	}
	
}
