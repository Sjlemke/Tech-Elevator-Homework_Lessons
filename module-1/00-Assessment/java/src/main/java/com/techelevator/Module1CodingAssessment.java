package com.techelevator;

// This is the application program for the assessment

public class Module1CodingAssessment {

	public static void main(String[] args) {
		
		System.out.println("Module 1 Coding Assessment\n");
	}
	//File Movieinput = new File("./Movieinput.csv");
	
	//Movieinput.csv.createNewFile();

public class movieRental {
	
	private String title; 
	private String format; 
	private boolean isPremiumMovie = true;
	private double rentalPrice;
    private double daysLate;
	
public movieRental(String title, String format, boolean isPremiumMovie) {
		// Put the code to test your assessment classes here
	}
	
public double DaysLate() {
	return daysLate;
}

public double getDaysLate() {
	if (daysLate == 0); {

	return 0.00;
	
}

	if(daysLate == 1) {
	 return 1.99;
		
	}
	
	if(daysLate == 2) {
		 return 3.99;
			
		}
	
	if(daysLate <= 3) {
		 return 19.99;
			
		}
	}



}
}
}

