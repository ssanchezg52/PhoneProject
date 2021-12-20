package com.example.model.phone;

import java.util.Objects;

public class Battery{
	
	private int mAhNumber;
	private final String UNIT_MEASURE = "mAh";
	private final int MULTIPLIER = 190;
	public Battery(Processor processor, Screen screen) {
		super();
		this.mAhNumber = calculateBatery(processor,screen);
	}
	
	public int calculateBatery(Processor processor, Screen screen) {
		float result = processor.calculateResult() + screen.getScreenSize();
		return (int) (result * MULTIPLIER);
	}
	
	public int getMAhNumber() {
		return mAhNumber;
	}
	public void setMAhNumber(int mAhNumber) {
		this.mAhNumber = mAhNumber;
	}
	@Override
	public int hashCode() {
		return Objects.hash(mAhNumber);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Battery other = (Battery) obj;
		return mAhNumber == other.mAhNumber;
	}
	@Override
	public String toString() {
		return "mAhNumber=" + mAhNumber + UNIT_MEASURE;
	}
	
	

}
