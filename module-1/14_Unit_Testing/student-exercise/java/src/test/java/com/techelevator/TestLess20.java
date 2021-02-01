package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestLess20 {

	@Test
	public void test__non_negative_number_is_less() {
	   Less20 testCode = new Less20();
	   boolean result = testCode.isLessThanMultipleOf20(18);
	   assertTrue(result);
	   result = testCode.isLessThanMultipleOf20(19);
	   assertTrue(result);
	   result = testCode.isLessThanMultipleOf20(20);
	   assertFalse(result);
	   }
}
