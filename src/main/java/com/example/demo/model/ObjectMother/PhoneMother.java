package com.example.demo.model.ObjectMother;

import java.util.LinkedList;
import java.util.List;

import com.example.demo.model.phone.Phone;
import com.example.demo.model.phone.Phone.BuilderPhone;

public class PhoneMother {
	
	private static LinkedList<String> brand = new LinkedList<>(List.of("Samsung" ,"Xiaomi","Apple"
			,"Motorola","Nokia", "Huawei", "Oppo","Honor","TCL","Alcatel","Doogee","Realme"
			,"Cubot","Oukitel","Ulefone","Elephone","Google","OnePlus","Nubia","Vivo"
			, "Meizu", "Mywigo", "Sony","Umidigi", "Vernee")); // 25
	private static LinkedList<String> model = new LinkedList<>(List.of("Edge x30", "Note 10 Pro",
			"GT Neo 2", "Nord 2", "Mate 20X", "11T", "iPhone 13", "F3", "Edge", "Find N"
			, "Pixel 2 XL", "10 PRO", "iQOO 8","X3 NFC", "11 Lite", "8i", "9AT"
			, "Pixel 3A", "GT Neo 2","C21Y", "Narzo 50i", "20SE", "Pixel 3", "Civi", "P40 Lite"
			, "GT Master", "iQOO 7", "Reno 6", "Galaxy S20", "K40", "9RT", "F2 PRO", "X60"
			, "Galaxy S21", "Magic 6", "9R","Z30", "G100", "E3", "KO76")); //40
	public static LinkedList<Phone> getPhoneList() {
		LinkedList<Phone> phoneList = new LinkedList<>();
		brand.forEach((concreteMark)->{
			model.forEach((concreteModel)->{
				phoneList.add(new BuilderPhone(concreteMark, concreteModel).builder());
			});
		});
		return phoneList;
	}

}
