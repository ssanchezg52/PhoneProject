package com.example.demo;

import java.time.Instant;
import java.util.Date;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.history.HistoricalPrice;
import com.example.demo.model.history.PriceHistoryRepository;
import com.example.demo.model.phone.Phone;
import com.example.demo.model.phone.PhoneRepository;
import com.example.demo.utiles.Utiles;

@SpringBootTest
class HistoryPhoneTest {
	
	@Autowired
	PhoneRepository phoneRepository;
	@Autowired
	PriceHistoryRepository historyRepository;

	@Test
	void test() {
		Iterable<Phone> phoneList = phoneRepository.findAll();
		phoneList.forEach((phone)->{
			for (int i = 0; i < 4; i++) {
				int valorateUser = Utiles.getRandomWholeNumber(1, 10);
				
			}
			
			historyRepository.save(new HistoricalPrice(phone, phone.getPrice(), Date.from(Instant.now())));
		});
//		int max= 28;
//		int min = 1;
//		Random random = new Random();
//		moviles.forEach(movil -> {
//            for (int i = 2; i < 7; i++) {
//                movil.setPrice(movil.getPrice()+(random.nextInt(max-min)+min));
//                historyRepository.save(new HistoricalPrice(movil,new Date(new Date().getTime() + (86400000*i))));
//            }
//        });
	}

}
