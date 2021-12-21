package com.example.demo.model.phone;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepository extends CrudRepository<Phone, Integer> {

}
