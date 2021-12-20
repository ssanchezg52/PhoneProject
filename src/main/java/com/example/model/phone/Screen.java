package com.example.model.phone;

import java.util.Objects;

public class Screen{
	
	private float screenSize;
	private final String UNIT_MEASURE = "''";
	public Screen(float screenSize) {
		super();
		this.screenSize = screenSize;
	}
	public float getScreenSize() {
		return screenSize;
	}
	public void setScreenSize(float screenSize) {
		this.screenSize = screenSize;
	}
	@Override
	public int hashCode() {
		return Objects.hash(screenSize);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Screen other = (Screen) obj;
		return Float.floatToIntBits(screenSize) == Float.floatToIntBits(other.screenSize);
	}
	@Override
	public String toString() {
		return screenSize + UNIT_MEASURE;
	}
	
	

}
