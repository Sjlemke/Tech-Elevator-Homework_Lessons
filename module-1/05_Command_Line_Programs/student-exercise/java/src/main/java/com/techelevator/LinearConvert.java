package com.techelevator;

import java.util.Scanner;

public class LinearConvert {    
	public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
    System.out.print("Input a value for inch: ");
    double feetConvert = input.nextDouble();
    input.nextLine();
    System.out.print("Enter 'f' for feet and 'm' for meters\n");
    String measureConvert = input.nextLine();
    double meters = 0;
    double feet = 0;
    if (measureConvert.charAt(0) == 'f') {
	meters = feetConvert * 0.3048;
    }
    else if (measureConvert.charAt(0) == 'm') {
	feet = meters * 3.2808399;
    }
System.out.println(feetConvert + " is " + feet + " feet is " + meters + " meters");
	}
}
