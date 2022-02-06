package com.example.demo.mock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.example.demo.controllers.PhoneController;
import com.example.demo.model.response.Response;
import com.example.demo.services.PhoneService;

public class PhoneControllerMock {
	
	@Autowired
	private PhoneController phoneController;
	
	public ResponseEntity<Response> getPhoneList() {
		return phoneController.getListPhoneWithResponse();	
	}

}
