package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestAnimalGroupName {
       //first we need to define an object with the methods we want to test
	AnimalGroupName testCode = new AnimalGroupName(); //object with the methods to be tested
	
	@Test   //here is a junit test
	public void test_correct_animal_group_returned_based_on_animal() {  //object with the methods to be tested
	assertEquals("Wrong animal group returned", "Herd", testCode.getHerd("Elephant"));
		//methods that are in the class we are testing:
		//String getHerd(String animalName)
		//The method returns a String - assertEquals
	    //Test 1 - send it Elephant and expect "Herd"
	    //Test 2 - send it walrus and expect unknown
	    //Test 3 - send it elephant and expect Herd"
	    //Test 4 - send it "ELEPHANT" and expect "Herd"
	assertEquals("Wrong animal group returned", "unknown", testCode.getHerd("Walrus"));
	assertEquals("Wrong animal group returned", "Herd", testCode.getHerd("ELEPHANT"));
	assertEquals("Wrong animal group returned", "Herd", testCode.getHerd("Elephant"));
	assertEquals("Wrong animal group returned", "Herd", testCode.getHerd("ElePhaNt"));

	
	}
}
