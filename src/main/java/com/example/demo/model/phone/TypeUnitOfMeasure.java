package com.example.demo.model.phone;

public enum TypeUnitOfMeasure {
	
	PROCCESOR("Ghz"),BATTERY("mAh"),RAM("GB"),SCREEN("''"), PRECIO("€");
	
	private final String unitOfMeasure;

	private TypeUnitOfMeasure(String unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
	}

	public String getUnitOfMeasure() {
		return unitOfMeasure;
	}

}
