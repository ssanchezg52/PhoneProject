package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.phone.Phone;
import com.example.demo.model.phone.PhoneRepository;

@SpringBootTest
class PriceChartTest {
	
	@Autowired
	PhoneRepository phoneRepository;
	Phone phone;
	int days = 730;
	
	@BeforeEach
	void testBefore() {
		do {
			Optional<Phone> phone = phoneRepository.findById(1);
			phone.ifPresent((e)->this.phone = e);
		} while(this.phone == null);
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
