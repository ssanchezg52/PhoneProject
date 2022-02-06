package com.example.demo.model.phone;

import java.util.Objects;

import javax.persistence.Embeddable;

import com.example.demo.utiles.Utiles;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Embeddable
public class Processor{
	
	private Integer coreNumber;
	private Float clockRate;
	
	public Processor() {
		super();
	}
	public Processor(int coreNumber) {
		this.coreNumber = coreNumber;
		this.clockRate = calculateVelocity();
	}	
	private Float calculateVelocity() {
		String result = "";
		if (coreNumber <= 4) {
			result = String.valueOf(Math.random()*(2-1)+1);
		}else {
			result = String.valueOf(Math.random()*(3.5-2)+2);
		}
		result = result.replace(",", ".");
		Float velocityConverted = Utiles.convertNumberTwoDecimals(Float.valueOf(result));
		return velocityConverted;
	}
	
	public float calculateResult() {
		return clockRate + (coreNumber * clockRate);
	}

	public int getCoreNumber() {
		return coreNumber;
	}
	public void setCoreNumber(int coreNumber) {
		this.coreNumber = coreNumber;
	}

	public Float getVelocity() {
		return clockRate;
	}

	public void setVelocity(Float velocity) {
		this.clockRate = velocity;
	}
	@Override
	public int hashCode() {
		return Objects.hash(coreNumber, clockRate);
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
		return coreNumber == other.coreNumber && Objects.equals(clockRate, other.clockRate);
	}
	@Override
	public String toString() {
		return "[coreNumber=" + coreNumber + ", velocity=" + clockRate +"]";
	}
	
}
