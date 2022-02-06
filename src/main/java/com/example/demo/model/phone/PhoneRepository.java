package com.example.demo.model.phone;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepository extends CrudRepository<Phone, Integer> {
	
	public Optional<Phone> findById(long id);
	public ArrayList<Phone> findByBrandStartingWith(String initialbrand);
	public ArrayList<Phone> findByModelStartingWith(String initialModel);
	public ArrayList<Phone> findByProcessor_CoreNumberEquals(Integer coreNumber);
	public ArrayList<Phone> findByAntutuGreaterThanEqualAndAntutuLessThanEqual(long antutuMin,long antutuMax);
	public ArrayList<Phone> findByPrizeGreaterThanEqualAndPrizeLessThanEqual(float prizeMin,float prizeMax);

}
