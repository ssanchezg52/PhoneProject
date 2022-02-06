package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.ObjectMother.PhoneMother;
import com.example.demo.model.phone.Phone;
import com.example.demo.model.phone.PhoneDTO;
import com.example.demo.model.phone.PhoneRepository;

@Service
public class PhoneService {
	
	PhoneRepository phoneRepository;
//	PhoneMapper phoneMapper = new PhoneMapperImpl();
	boolean result = false;
	
	public PhoneService(PhoneRepository phoneRepository) {
		super();
		this.phoneRepository = phoneRepository;
		saveAll();
	}

	public void saveAll() {
		phoneRepository.saveAll(PhoneMother.getPhoneList());
	}

	public ArrayList<Phone> getPhoneList(int limit) {
		ArrayList<Phone> findAll = (ArrayList<Phone>) phoneRepository.findAll();
		if (limit == -1) {
			return findAll;
		}
		ArrayList<Phone> phoneListWithLimit = new ArrayList<>();
		for (int i = 0; i < limit; i++) {
			phoneListWithLimit.add(findAll.get(i));
		}
		return phoneListWithLimit;
		
		
	}
	
	public ArrayList<Phone> getPhoneListByCoreNumber(int coreNumber) {
		return phoneRepository.findByProcessor_CoreNumberEquals(coreNumber);
	}

	public List<Phone> searchByPrice(float priceMin, float priceMax) {
		return this.phoneRepository.findByPrizeGreaterThanEqualAndPrizeLessThanEqual(priceMin, priceMax);
	}
	
	public ArrayList<Phone> searchByAntutu(long antutuMin, long antutuMax) {
		return phoneRepository.findByAntutuGreaterThanEqualAndAntutuLessThanEqual(antutuMin, antutuMax);
	}
	
	public boolean updatePhone(long id, PhoneDTO phoneDTO) {
//	    Phone phone = phoneRepository.findById(id).get();
//	    phoneMapper.updatePhoneFromDto(phoneDTO, phone);
//	    phoneRepository.save(phone);
	    return true;
	}

	public List<Phone> searchByBrand(String initialBrand) {
		return phoneRepository.findByBrandStartingWith(initialBrand);
	}
	
	public List<Phone> searchByModel(String initialModel) {
		return phoneRepository.findByModelStartingWith(initialModel);
	}
	
	public Optional<Phone> getPhoneById(Long id) {
		return phoneRepository.findById(id);
	}
	
}
