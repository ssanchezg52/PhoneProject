package com.example.demo;

import java.util.LinkedList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.ObjectMother.PhoneMother;
import com.example.demo.model.history.PriceHistoryRepository;
import com.example.demo.model.phone.Phone;
import com.example.demo.model.phone.PhoneRepository;

@SpringBootTest
class JpahPhoneProyect1ApplicationTests {

	@Autowired
	PhoneRepository phoneRepository;
	@Autowired
	PriceHistoryRepository priceHistoryRepository;

	@Test
	void contextLoads() {
		LinkedList<Phone> phoneList = PhoneMother.getPhoneList();
		phoneRepository.saveAll(phoneList);
	}

}
