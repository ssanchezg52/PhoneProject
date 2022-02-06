package com.example.demo.controllers;

import java.time.LocalDateTime;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.phone.Phone;
import com.example.demo.model.phone.PhoneDTO;
import com.example.demo.model.response.Response;
import com.example.demo.services.PhoneService;

@RestController
public class PhoneController {
	
	@Autowired
	private PhoneService phoneService;
	
	@GetMapping("getListPhones")
	public ResponseEntity<Response> getListPhoneWithResponse() {
		System.err.println("entrango en getlist");;
		ResponseEntity<Response> ok = ResponseEntity.ok(Response.builder()
				.TimeStamp(LocalDateTime.now())
				.Status(HttpStatus.OK)	 
				.Message("lista de personas obtenida")
				.Data(Map.of("listaPersonas",this.phoneService.getPhoneList(20))).build());
		System.err.println(ok);
		return ok;
	}
	
	@GetMapping("getListPhonesWithoutResponse")
	public List<Phone> getListPhoneWithoutResponse() {
		return this.phoneService.getPhoneList(20);
	}
	
	@GetMapping("id")
	public Optional<Phone> getPhoneById(@RequestParam Long id) {
		return phoneService.getPhoneById(id);
	}
	
	@GetMapping("searchByBrand/{initialBrand}")
	public List<Phone> searchByBrand(@PathVariable("initialBrand") String initialBrand) {
		return phoneService.searchByBrand(initialBrand);
	}
	
	@GetMapping("searchByModel")
	public List<Phone> searchByModel(@RequestParam String initialModel) {
		return phoneService.searchByModel(initialModel);
	}
	
	@GetMapping("searchByProcessor/coreNumberEquals")
	public List<Phone> searchByModel(@RequestParam int coreNumber) {
		return phoneService.getPhoneListByCoreNumber(coreNumber);
	}
	
	@GetMapping("searchByPrice/intervalPrice")
	public List<Phone> searchByPrice(@RequestParam float priceMin, @RequestParam float priceMax) {
		return phoneService.searchByPrice(priceMin,priceMax);
	}
	
	@GetMapping("searchByPrice/intervalAntutu")
	public List<Phone> searchByAntutu(@RequestParam long antutuMin, @RequestParam long antutuMax) {
		return phoneService.searchByAntutu(antutuMin,antutuMax);
	}
	
	@PutMapping("updatePhone")
	public boolean updatePhone(@RequestParam long id, @RequestBody PhoneDTO phoneDTO) {
		return phoneService.updatePhone(id, phoneDTO);
	}

}
