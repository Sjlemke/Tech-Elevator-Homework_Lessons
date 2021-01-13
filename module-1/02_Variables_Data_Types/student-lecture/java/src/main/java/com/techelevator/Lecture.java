// slash-slash indicates a comment in your Java code
// a comment is information for a human who might read your code
// a comment line is ignored by the compiled
/* start of a block comment
 *  slash-asterisk starts a block comment
 *  all lines between the slash-asterisk and asterisk-slash
 *  are treated as comment and ignored by the compiler.
 * */ // end of block comment
 

package com.techelevator; // the package the holds the classes for this application

public class Lecture { //A class within the application

	public static void main(String[] args) { // a function in the application class
											// every Java application has at least a main () function
	// variables are used to hold data needed for the program
	// Data and understanding the data is fundamental to writing successful code program
		
	// in Java a variable is defined: datatype name;
	//								  datatype name = initial-value;
	// If an initial value is not specified when you define the variable its contents are unknownen
	//Its a good idea to ALWAYS initialize variables
    // Variable names must be unique within a block code
	
	//Common data types
		
	//If value is nemeric without a decimal point: int
	//If value is numeric with a decimal point: double
    //If the value is a single charachter: char
	//If the value is multiple characters or words: string
	// If the value is true or false: boolean
		
	//String is a "special" data type which we will discuss later
    
		/*
		1. Create a variable to hold an int and call it numberOfExercises.
			Then set it to 26.
		*/
		int numberOfExercises = 26;
		//If want to indicate a String value put it inside " "
		// display these words and the variable.
		System.out.println("The value in numberOfExercises is " + numberOfExercises); // Display whatever is between ()

		/*
		2. Create a variable to hold a double and call it half.
			Set it to 0.5.
		*/ double half = .5;
		System.out.println("half contains: " + half);

		/*
		3. Create a variable to hold a String and call it name.
			Set it to "TechElevator".
		*/String name = " Tech Elevator";

		System.out.println("name is:" + name);

		/*
		4. Create a variable called seasonsOfFirefly and set it to 1.
		*/int seasonsOfFirefly = 1;

		System.out.println(seasonsOfFirefly);

		/*
		5. Create a variable called myFavoriteLanguage and set it to "Java".
		*/String myFavoriteLanguage = "Java";

		System.out.println(myFavoriteLanguage);

		/*
		6. Create a variable called pi and set it to 3.1416.
		*/ double pi = 3.1416;

		System.out.println("value of pi is: " + pi);

		/*
		7. Create and set a variable that holds your name.
		*/
		String myName = "Sam";
		System.out.println("My name is " + myName);

		/*
		8. Create and set a variable that holds the number of buttons on your mouse.
		*/int numMouseButtons = 2;
		System.out.println("Buttons " + numMouseButtons);

		/*
		9. Create and set a variable that holds the percentage of battery left on
		your phone.
		*/
		double pctBatteryLife = 0;
		 System.out.println("Battery life: " + pctBatteryLife);
		/*
		10. Create an int variable that holds the difference between 121 and 27.
		*/
		 int diff = 121 - 27;
		 System.out.println("diff = "  + diff);
		/*
		11. Create a double that holds the addition of 12.3 and 32.1.
		*/
		 double sum = 12.3 + 32.1;
		 System.out.println("sum: " + sum);
		 

		/*
		12. Create a String that holds your full name.
		*/
		 String fullName = "Samantha Lemke";
		 System.out.println("My name is" + fullName);

		/*
		13. Create a String that holds the word "Hello, " concatenated onto your
		name from above.
		*/
		 String Samantha = (fullName + "Hello");
		/*
		14. Add a " Esquire" onto the end of your full name and save it back to
		the same variable.
		*/
		 fullName = fullName + " Esquire";
		/*
		
		15. Now do the same as exercise 14, but use the += operator.
		*/
		String movie = "Saw";
		movie = movie + "2";
		movie = movie + 0;
		System.out.println(movie);
		/*
		16. Create a variable to hold "Saw" and add a 2 onto the end of it.
		*/
       
		/*
		17. Add a 0 onto the end of the variable from exercise 16.
		*/

		/*
		18. What is 4.4 divided by 2.2?
		*/
        System.out.println("4.4 / 2.2 is: " + 4.4/ 2.2);
		/*
		19. What is 5.4 divided by 2?
		*/
        System.out.println("4.4 / 2.2 is: " + 5.4 / 2);

		/*
		20. What is 5 divided by 2?
		*/
        System.out.println("5 / 2 is: " + 5 / 2);

		/*
		21. What is 5.0 divided by 2?
		*/
       System.out.println("5 / 2 is: " + 5 / 2);
		/*
		22. What is 66.6 divided by 100? Is the answer you get right or wrong?
		*/
         System.out.println("66.6 / 100 is " + 66.6 / 100);
		/*
		23. If I divide 5 by 2, what's my remainder?
		*/
       System.out.println("5 % 2 is: " + 5 % 2);
		/*
		24. What is 1,000,000,000 * 3?
		*/
       System.out.println("1000000000 * 3L is " + 1000000000*3L);
		/*
		25. Create a variable that holds a boolean called doneWithExercises and
		set it to false.
		*/
        boolean doneWithExercises = false;
       System.out.println("doneWithExercises=" + doneWithExercises);
		/*
		26. Now set doneWithExercise to true.
		*/
        doneWithExercises = true;
	  System.out.printls(doneWithExercises=" + doneWithExercises);
	}

}
