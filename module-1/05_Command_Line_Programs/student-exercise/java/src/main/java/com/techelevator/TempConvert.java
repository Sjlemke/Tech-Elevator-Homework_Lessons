package com.techelevator;

import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
	    System.out.print("Enter 'c' for Celcius or 'f' for Fahrenheit\n");
	    String temperatureType = scanner.nextLine();
	    if (temperatureType.charAt(0) == 'f') {
	    System.out.print("Enter temperature in Fahrenheit");
	    int Tf = scanner.nextInt(); 
		int Tc = (Tf - 32) * 5 / 9;
		System.out.println("Temperature results in Celcius: " + Tc); 
		System.out.println("Old temperature results in Fahrenheit: " + Tf); 
        }
	    else if(temperatureType.charAt(0) == 'c') {
	    System.out.print("Enter temperature in Celcius");
	    int Tc = scanner.nextInt();
		int Tf = (Tc * 9 / 5) + 32;
		System.out.println("Temperature results in Fahrenheit: " + Tf); 
		System.out.println("Old temperature results in Celcius: " + Tc); 
	    }
	    scanner.close();
	}
}
