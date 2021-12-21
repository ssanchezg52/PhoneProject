package com.example.demo.phoneTests;

import org.junit.jupiter.api.Test;

import com.example.demo.model.phone.Brand;
import com.example.demo.model.phone.BuilderPhone;
import com.example.demo.model.phone.Model;
import com.example.demo.model.phone.Phone;


class PhoneTest {
	
//	@Test
//	void testMain() {
//		LinkedList<Phone> phoneList = PhoneMother.getPhoneList();
//		phoneList.forEach((phone)->{
//			System.err.println(phone);
//		});
//	}

	@Test
	void test() {
		for (int i = 0; i < 5; i++) {
			Phone phone = new BuilderPhone(new Brand("Samsung"), new Model("AC 200")).builder();
			System.out.println(phone);
		}
	}

}
