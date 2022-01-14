package com.example.demo.phoneTests;

import org.junit.jupiter.api.Test;

import com.example.demo.model.phone.Phone;
import com.example.demo.model.phone.Phone.BuilderPhone;


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
			Phone phone = new BuilderPhone("Samsung", "AC 200").builder();
			System.out.println(phone);
		}
	}

}
