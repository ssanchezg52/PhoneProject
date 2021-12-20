package com.example.model.phone;

import java.text.DecimalFormat;
import java.util.Objects;

public class Processor{
	
	private int coreNumber;
	private String velocity;
	private final String UNIT_MEASURE = "Ghz";
	public Processor(int coreNumber) {
		this.coreNumber = coreNumber;
		this.velocity = calculateVelocity();
	}	
	private String calculateVelocity() {
		DecimalFormat decimalFormat = new DecimalFormat("#.##");
		if (coreNumber <= 4) {
			return decimalFormat.format(Math.random()*(2-1)+1);
		}
		if (coreNumber > 4) {
			return decimalFormat.format(Math.random()*(3.5-2)+2);
		}
		return null;
	}
	
	public float calculateResult() {
		String replace = velocity.replace(",", ".");
		return Float.valueOf(replace) + (coreNumber * Float.valueOf(replace));
	}

	public int getCoreNumber() {
		return coreNumber;
	}
	public void setCoreNumber(int coreNumber) {
		this.coreNumber = coreNumber;
	}
	public String getVelocity() {
		return velocity;
	}
	public void setVelocity(String velocity) {
		this.velocity = velocity;
	}
	@Override
	public int hashCode() {
		return Objects.hash(coreNumber, velocity);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Processor other = (Processor) obj;
		return coreNumber == other.coreNumber && Objects.equals(velocity, other.velocity);
	}
	@Override
	public String toString() {
		return "[coreNumber=" + coreNumber + ", velocity=" + velocity + UNIT_MEASURE+"]";
	}
	
}
