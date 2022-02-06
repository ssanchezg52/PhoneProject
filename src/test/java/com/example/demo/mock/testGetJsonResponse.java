package com.example.demo.mock;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.demo.controllers.PhoneController;

class testGetJsonResponse {

	@MockBean
	PhoneController phoneControllerReal;
	
	@Autowired
	PhoneControllerMock phoneControllerMock;
	
	@Test
	void test() {
		when(phoneControllerMock.getPhoneList()).thenReturn(phoneControllerReal.getListPhoneWithResponse());
		
	}

}
