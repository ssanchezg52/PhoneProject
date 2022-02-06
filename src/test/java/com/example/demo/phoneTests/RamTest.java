package com.example.demo.phoneTests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.demo.model.phone.RamCalculator;

class RamTest {

	@Test
	void test() {
		float ram = RamCalculator.calculateCapacity(4);
		assertEquals(2, ram);
	}
}