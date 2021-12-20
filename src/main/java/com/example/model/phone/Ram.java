package com.example.model.phone;

import java.util.Objects;

public class Ram{

	private float capacity;
	private final String UNIT_MEASURE = "GB";
	private final int MEGABYTES_PER_CORE = 500;
	private final int CONVERTER_MB_TO_GB = 1000;

	public Ram(int core) {
		this.capacity = calculateCapacity(core);
	}

	private float calculateCapacity(int core) {
		float megabytes = core * MEGABYTES_PER_CORE;
		float gigabytes = converterMegabytesToGygabytes(megabytes);
		return gigabytes;
	}

	private float converterMegabytesToGygabytes(float megabytes) {
		return megabytes / CONVERTER_MB_TO_GB;
	}
	
	public float getCapacity() {
		return capacity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(capacity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ram other = (Ram) obj;
		return Float.floatToIntBits(capacity) == Float.floatToIntBits(other.capacity);
	}

	@Override
	public String toString() {
		return capacity + UNIT_MEASURE;
	}
}