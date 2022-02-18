	package com.example.demo.controllers;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.phone.PhoneDTO;
import com.example.demo.model.response.Response;
import com.example.demo.services.PhoneService;

@RestController
public class PhoneController {
	
	@Autowired
	private PhoneService phoneService;
	
	@GetMapping("getPhoneList/{page}/{size}")
	public ResponseEntity<Response> getListPhoneByPage(@PathVariable int page, @PathVariable int size){
		ResponseEntity<Response> ok = ResponseEntity.ok(Response.builder()
				.TimeStamp(LocalDateTime.now())
				.Status(HttpStatus.OK)	 
				.Message("lista de moviles obtenida")
				.Data(Map.of("phoneListContent",this.phoneService.getPhoneListByPage(page,size))).build());
		return ok;
	}
	
	@GetMapping("searchById/{id}")
	public ResponseEntity<Response> getPhoneById(@PathVariable("id") Long id) {
		ResponseEntity<Response> ok = ResponseEntity.ok(Response.builder()
				.TimeStamp(LocalDateTime.now())
				.Status(HttpStatus.OK)	 
				.Message("Movil especifico obtenido")
				.Data(Map.of("phoneSpecific",this.phoneService.getPhoneById(id))).build());
		return ok;
	}
	
	@GetMapping("searchByNamePhone/{brand}/{model}")
	public ResponseEntity<Response> searchByNamePhone(@PathVariable("brand") String brand, @PathVariable("model") String model){
		ResponseEntity<Response> ok = ResponseEntity.ok(Response.builder()
				.TimeStamp(LocalDateTime.now())
				.Status(HttpStatus.OK)	 
				.Message("Movil especifico obtenido")
				.Data(Map.of("phoneSpecific",this.phoneService.getPhoneByBrandAndModel(brand, model))).build());
		return ok;
	}
	
	@GetMapping("searchByBrand/{initialBrand}/{page}")
	public ResponseEntity<Response> searchByBrand(@PathVariable("initialBrand") String initialBrand, @PathVariable("page") int page) {
		ResponseEntity<Response> ok = ResponseEntity.ok(Response.builder()
				.TimeStamp(LocalDateTime.now())
				.Status(HttpStatus.OK)	 
				.Message("lista de moviles con una marca especifica obtenida")
				.Data(Map.of("phoneListContent",this.phoneService.searchByBrand(initialBrand,page))).build());
		return ok;
	}
	
	@GetMapping("searchByModel/{initialModel}")
	public ResponseEntity<Response> searchByModel(@PathVariable("initialModel") String initialModel) {
		ResponseEntity<Response> ok = ResponseEntity.ok(Response.builder()
				.TimeStamp(LocalDateTime.now())
				.Status(HttpStatus.OK)	 
				.Message("lista de moviles por modelo especifico obtenido")
				.Data(Map.of("phoneList",this.phoneService.searchByModel(initialModel))).build());
		return ok;
	}
	
	@GetMapping("searchByProcessor/coreNumberEquals/{coreNumber}")
	public ResponseEntity<Response> searchByProcessorCore(@PathVariable("coreNumber") int coreNumber) {
		ResponseEntity<Response> ok = ResponseEntity.ok(Response.builder()
				.TimeStamp(LocalDateTime.now())
				.Status(HttpStatus.OK)	 
				.Message("lista de moviles por nucleo de procesador obtenida")
				.Data(Map.of("phoneList",this.phoneService.getPhoneListByCoreNumber(coreNumber))).build());
		return ok;
	}
	
	@GetMapping("searchByPrice/intervalPrice/{priceMin}/{priceMax}")
	public ResponseEntity<Response> searchByPrice(@PathVariable("priceMin") float priceMin, @PathVariable("priceMax") float priceMax) {
		ResponseEntity<Response> ok = ResponseEntity.ok(Response.builder()
				.TimeStamp(LocalDateTime.now())
				.Status(HttpStatus.OK)	 
				.Message("lista de moviles por precio obtenida")
				.Data(Map.of("phoneList",this.phoneService.searchByPrice(priceMin, priceMax))).build());
		return ok;
	}
	
	@GetMapping("searchByPrice/intervalAntutu/{antutuMin}/{antutuMax}")
	public ResponseEntity<Response> searchByAntutu(@PathVariable("antutuMin") long antutuMin, @PathVariable("antutuMax") long antutuMax) {
		ResponseEntity<Response> ok = ResponseEntity.ok(Response.builder()
				.TimeStamp(LocalDateTime.now())
				.Status(HttpStatus.OK)	 
				.Message("lista de moviles por antutu obtenida")
				.Data(Map.of("phoneList",this.phoneService.searchByAntutu(antutuMin, antutuMax))).build());
		return ok;
	}
	
	@PutMapping("updatePhone/{id}")
	public boolean updatePhone(@PathVariable("id") long id, @RequestBody PhoneDTO phoneDTO) {
		return phoneService.updatePhone(id, phoneDTO);
	}

}
