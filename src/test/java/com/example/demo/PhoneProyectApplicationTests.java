package com.example.demo;

import java.util.LinkedList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.ObjectMother.PhoneMother;
import com.example.demo.model.phone.Brand;
import com.example.demo.model.phone.BrandRepository;
import com.example.demo.model.phone.Model;
import com.example.demo.model.phone.ModelRepository;
import com.example.demo.model.phone.Phone;
import com.example.demo.model.phone.PhoneRepository;

@SpringBootTest
class PhoneProyectApplicationTests {
	
	@Autowired
	PhoneRepository phoneRepository;
	@Autowired
	BrandRepository brandRepository;
	@Autowired
	ModelRepository modelRepository;

	@Test
	void contextLoads() {
		LinkedList<Brand> brandList = PhoneMother.getBrandList();
		brandRepository.saveAll(brandList);
		LinkedList<Model> modelList = PhoneMother.getModelList();
		modelRepository.saveAll(modelList);
		LinkedList<Phone> phoneList = PhoneMother.getPhoneList();
		phoneRepository.saveAll(phoneList);
	}

}
