package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestNonStart {
		
	@Test
	public void testReturnConcatenation() {
		NonStart testCode = new NonStart();
		assertEquals("Concatenation returned", "a.substring" + "b.substring", testCode.NonStart("String"));

	}

}
