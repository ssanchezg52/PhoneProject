package com.example.phoneTests;

import org.junit.jupiter.api.Test;

import com.example.model.phone.BuilderPhone;
import com.example.model.phone.Phone;


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
