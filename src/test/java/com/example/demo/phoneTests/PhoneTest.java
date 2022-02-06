package com.example.demo.phoneTests;

import org.junit.jupiter.api.Test;

import com.example.demo.model.phone.Phone;
import com.example.demo.model.phone.Phone.BuilderPhone;
import com.example.demo.model.phone.Processor;


class PhoneTest {

	@Test
	void test() {
		for (int i = 0; i < 5; i++) {
			Phone phone = new BuilderPhone("Samsung", "AC 200").builder();
			System.out.println(phone);
		}
	}

}
