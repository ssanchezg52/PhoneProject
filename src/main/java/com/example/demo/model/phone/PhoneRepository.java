package com.example.demo.model.phone;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepository extends PagingAndSortingRepository<Phone, Integer> {
	
	public Optional<Phone> findById(long id);
	public Page<Phone> findByBrandStartingWith(String initialbrand,Pageable pageRequest);
	public ArrayList<Phone> findByModelStartingWith(String initialModel);
	public ArrayList<Phone> findByProcessor_CoreNumberEquals(Integer coreNumber);
	public ArrayList<Phone> findByAntutuGreaterThanEqualAndAntutuLessThanEqual(long antutuMin,long antutuMax);
	public ArrayList<Phone> findByPriceGreaterThanEqualAndPriceLessThanEqual(float prizeMin,float prizeMax);
	public Optional<Phone> findByBrandEqualsAndModelEquals(String brand,String model);

}
