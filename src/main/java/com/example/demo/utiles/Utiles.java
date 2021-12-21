package com.example.demo.utiles;

public class Utiles {
	
	public static int getRandomWholeNumber(int min, int max) {
		return (int) (Math.random()*(max-min)+min);
	}
	
	public static float getRandomDecimalNumber(int min, int max) {
		return (float) (Math.random()*(max-min)+min);
	}

}
