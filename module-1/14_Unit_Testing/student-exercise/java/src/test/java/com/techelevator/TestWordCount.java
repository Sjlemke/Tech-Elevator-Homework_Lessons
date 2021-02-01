package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;


public class TestWordCount {
 WordCount testCode = new WordCount();

	@Test
	public void test_get_count() {
	int output = testCode.WordCount("Alphabet");
	assertEquals(0, output);
				}
		}

