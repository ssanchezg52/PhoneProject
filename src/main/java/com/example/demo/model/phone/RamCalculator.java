package com.example.demo.model.phone;

public class RamCalculator {
	
	private static final int MEGABYTES_PER_CORE = 500;
	private static final int CONVERTER_MB_TO_GB = 1000;
	
	public static Float calculateCapacity(int core) {
		float megabytes = core * MEGABYTES_PER_CORE;
		float gigabytes = converterMegabytesToGygabytes(megabytes);
		return gigabytes;
	}

	private static float converterMegabytesToGygabytes(float megabytes) {
		return megabytes / CONVERTER_MB_TO_GB;
	}

}
