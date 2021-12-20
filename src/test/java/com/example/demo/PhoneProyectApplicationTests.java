package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.model.phone.Phone;
import com.example.model.phone.PhoneRepository;

@SpringBootTest
class PhoneProyectApplicationTests {
	
	@Autowired
	PhoneRepository phoneRepository;

	@Test
	void contextLoads() {
//		LinkedList<Phone> phoneList = PhoneMother.getPhoneList();
//		phoneRepository.saveAll(phoneList);
		Phone phone = new Phone();
		phoneRepository.save(phone);
	}

}
