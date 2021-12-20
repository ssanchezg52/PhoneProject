package com.example.model.ObjectMother;

import java.util.LinkedList;
import java.util.List;

import com.example.model.phone.BuilderPhone;
import com.example.model.phone.Phone;

public class PhoneMother {
	
	private static LinkedList<String> mark = new LinkedList<>(List.of("Samsung","Xiaomi","Apple","Motorola","Nokia"
			,"Huawei","Oppo","Honor","	TCL","Alcatel","Doogee","Realme","Cubot","Oukitel","Ulefone"));
	private static LinkedList<String> model = new LinkedList<>(List.of("Edge x30","Note 8","Note 10 Pro","GT Neo 2","Nord 2"
			,"Mate 20X","11T","iPhone 13","F3","Edge","Find N","10 PRO","X3 NFC","11 Lite","8i","9AT","GT Neo 2","C21Y"
			,"Narzo 50i","20SE"));
	
	public static LinkedList<Phone> getPhoneList() {
		LinkedList<Phone> phoneList = new LinkedList<>();
		mark.forEach((concreteMark)->{
			model.forEach((concreteModel)->{
				phoneList.add(new BuilderPhone(concreteMark, concreteModel).builder());
			});
		});
		return phoneList;
	}
	

}
