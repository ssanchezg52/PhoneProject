package com.example.demo.model.phone;

import java.text.DecimalFormat;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;

@Embeddable
public class Screen{
	@Column(name = "screen")
	private String screenSize;
	@Transient
	private final String UNIT_MEASURE_SCREEN = "''";
	
	public Screen() {
		super();
	}
	public Screen(float screenSize) {
		super();
		this.screenSize = convertNumberTwoDecimals(screenSize)+UNIT_MEASURE_SCREEN;
	}
	private String convertNumberTwoDecimals(float screenSizeConcrete) {
		DecimalFormat decimalFormat = new DecimalFormat("#.##");
		String format = decimalFormat.format(screenSizeConcrete);
		return format.replace(",", ".");
	}
	public float getScreenSize() {
		String[] split = screenSize.split("'");
		return Float.valueOf(split[0]);
	}
	public void setScreenSize(float screenSize) {
		this.screenSize = screenSize+UNIT_MEASURE_SCREEN;
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
		return Objects.equals(screenSize, other.screenSize);
	}
	@Override
	public String toString() {
		return screenSize;
	}
	
	

}
