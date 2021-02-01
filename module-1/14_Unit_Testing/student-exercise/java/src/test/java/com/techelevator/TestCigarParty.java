package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCigarParty {
	
	@Test
	public void test__successful_parties_based_on_cigars() {
	   CigarParty testCode = new CigarParty();
	   boolean res = testCode.haveParty(30, false);
	   assertFalse(res);
	   res = testCode.haveParty(50, false);
	   assertTrue(res);
	   res = testCode.haveParty(70, true);
	   assertTrue(res);
	   }
}
