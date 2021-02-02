package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestStringBits {
	
	StringBits testCode = new StringBits();
	
	@Test
	public void test_return_Bits_Of_String() {
	String res = testCode.getBits("Hello");
	equals(res);	
		   }
	}


