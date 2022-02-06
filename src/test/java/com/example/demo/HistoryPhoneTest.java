package com.example.demo;

import java.time.Instant;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.history.HistoricalPrice;
import com.example.demo.model.history.PriceHistoryRepository;
import com.example.demo.model.phone.Phone;
import com.example.demo.model.phone.PhoneRepository;

@SpringBootTest
class HistoryPhoneTest {
	
	@Autowired
	PhoneRepository phoneRepository;
	@Autowired
	PriceHistoryRepository historyRepository;

	@Test
	void test() {
		Iterable<Phone> findAll = phoneRepository.findAll();
		findAll.forEach((phone)->{
			historyRepository.save(new HistoricalPrice(phone, phone.getPrize(), Date.from(Instant.now())));
		});
	}

}
