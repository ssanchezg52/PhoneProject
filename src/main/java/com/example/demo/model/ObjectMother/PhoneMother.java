package com.example.demo.model.ObjectMother;

import java.util.LinkedList;
import java.util.List;

import com.example.demo.model.phone.Brand;
import com.example.demo.model.phone.BuilderPhone;
import com.example.demo.model.phone.Model;
import com.example.demo.model.phone.Phone;

public class PhoneMother {
	
	private static LinkedList<Brand> brand = new LinkedList<>(List.of(new Brand("Samsung") ,new Brand("Apple")
			,new Brand("Motorola"),new Brand("Nokia"), new Brand("Huawei"), new Brand("Oppo"),new Brand("Honor")
			,new Brand("TCL"),new Brand("Alcatel"),new Brand("Doogee"),new Brand("Realme"),new Brand("Cubot")
			,new Brand("Oukitel"),new Brand("Ulefone"),new Brand("Elephone"),new Brand("Google"),new Brand("OnePlus")
			,new Brand("Nubia"),new Brand("Vivo"), new Brand("Meizu"), new Brand("Mywigo"), new Brand("Sony"),
			new Brand("Umidigi"), new Brand("Vernee"), new Brand("Wiko"), new Brand("ZTE"),new Brand("Lenovo")));
	private static LinkedList<Model> model = new LinkedList<>(List.of(new Model("Edge x30"), new Model("Note 10 Pro"),
			new Model("GT Neo 2"), new Model("Nord 2"), new Model("Mate 20X"), new Model("11T"), new Model("iPhone 13")
			, new Model("F3"), new Model("Edge"), new Model("Find N"), new Model("Pixel 2 XL"), new Model("10 PRO")
			, new Model("iQOO 8"), new Model("X3 NFC"), new Model("11 Lite"), new Model("8i"), new Model("9AT")
			, new Model("Pixel 3A"), new Model("GT Neo 2"), new Model("C21Y"), new Model("Narzo 50i"), new Model("20SE")
			, new Model("Pixel 3"), new Model("Civi"), new Model("P40 Lite"), new Model("GT Master"), new Model("iQOO 7")
			, new Model("Reno 6"), new Model("Galaxy S20"), new Model("K40"), new Model("9RT"), new Model("F2 PRO")
			, new Model("X60"), new Model("Galaxy S21"), new Model("Magic 6"), new Model("9R"), new Model("Z30")
			, new Model("G100")));
	public static LinkedList<Phone> getPhoneList() {
		LinkedList<Phone> phoneList = new LinkedList<>();
		brand.forEach((concreteMark)->{
			model.forEach((concreteModel)->{
				phoneList.add(new BuilderPhone(concreteMark, concreteModel).builder());
			});
		});
		return phoneList;
	}
	
	public static LinkedList<Brand> getBrandList() {
		return brand;
	}
	
	public static LinkedList<Model> getModelList() {
		return model;
	}
	

}
