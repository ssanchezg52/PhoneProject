package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.model.phone.Phone;
import com.example.demo.model.phone.PhoneDTO;
import com.example.demo.model.phone.PhoneMapper;
import com.example.demo.model.phone.PhoneMapperImpl;
import com.example.demo.model.phone.PhoneRepository;

@Service
public class PhoneService {
	
	@Autowired
	PhoneRepository phoneRepository;
	PhoneMapper phoneMapper = new PhoneMapperImpl();
	boolean result = false;	
	
	public Page<Phone> getPhoneListByPage(int page, int size){
		return this.phoneRepository.findAll(PageRequest.of(page, size));
	}
	
	public ArrayList<Phone> getPhoneListByCoreNumber(int coreNumber) {
		return phoneRepository.findByProcessor_CoreNumberEquals(coreNumber);
	}

	public List<Phone> searchByPrice(float priceMin, float priceMax) {
		return this.phoneRepository.findByPriceGreaterThanEqualAndPriceLessThanEqual(priceMin, priceMax);
	}
	
	public ArrayList<Phone> searchByAntutu(long antutuMin, long antutuMax) {
		return phoneRepository.findByAntutuGreaterThanEqualAndAntutuLessThanEqual(antutuMin, antutuMax);
	}
	
	public Page<Phone> searchByBrand(String initialBrand, int page) {
		return phoneRepository.findByBrandStartingWith(initialBrand,PageRequest.of(page, 12));
	}
	
	public List<Phone> searchByModel(String initialModel) {
		return phoneRepository.findByModelStartingWith(initialModel);
	}
	
	public Optional<Phone> getPhoneById(Long id) {
		return phoneRepository.findById(id);
	}
	
	public Optional<Phone> getPhoneByBrandAndModel(String brand,String model){
		return this.phoneRepository.findByBrandEqualsAndModelEquals(brand, model);
	}
	
	public boolean updatePhone(long id, PhoneDTO phoneDTO) {
	    Phone phone = phoneRepository.findById(id).get();
	    phoneMapper.updatePhoneFromDto(phoneDTO, phone);
	    phoneRepository.save(phone);
	    return true;
	}
	
}
