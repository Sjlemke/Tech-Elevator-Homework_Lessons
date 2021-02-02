package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestNonStart {
		
	@Test
	public void testReturnConcatenation() {
		NonStart testCode = new NonStart();
		   String res = testCode.getPartialString("Hello", "There");
		   equals(res);
		   res = testCode.getPartialString("java", "code");
		   equals(res);
		   res = testCode.getPartialString("shotl", "java");
		   equals(res);
	}
}
