package com.techelevator;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FizzWriter {

	public static void main(String[] args) throws IOException {
		
		File FizzBuzzFile = new File("./FizzBuzz.txt");
		
		FizzBuzzFile.createNewFile();
		
		PrintWriter fizzPrinter = new PrintWriter(FizzBuzzFile);
		
		for(Integer i = 1; i < 301; i++) {		
		if((i % 3 == 0) && (i % 5 == 0)){
			fizzPrinter.write("#"+ i +": FizzBuzz\n");
		}
		if ((i % 5 == 0) || (i.toString().contains("5"))) {
			fizzPrinter.write("#" + i + ": " + "Buzz\n");
		}
		if ((i % 3 == 0 ) || (i.toString().contains("3"))) {
			fizzPrinter.write("#" + i + ": " + "Fizz\n");
		} else {
			fizzPrinter.write("#" + i + ": " + i  + "\n");
		}
		}
		

fizzPrinter.close();
}
}

//fizzBuzz.txt  //print out messeges for program started and ended. 