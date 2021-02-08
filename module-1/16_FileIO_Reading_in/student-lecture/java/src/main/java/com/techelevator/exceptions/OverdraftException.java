package com.techelevator.exceptions;

//THis is an example of a user/programmer defined Exception
//defined becasue the error we went to find it not a standard system error
// It is an application defined error

//Define a class that extends Exception
public class OverdraftException extends Exception {
//Code what the exception is supposed to do. In this case, if a withdrawl would result in an overdraft, throw this exception
/// The sysytem and Java dont know what an overdraft is, or that its a problem, thats why we write our own. 	
	private double overdraftAmount = 0;  //Data member to hold the amount sent this Excpetion is thrown
	//The constructor for the Exception is where the code for teh Exception goes. In this case we are coding Exception for an overdraft.
	public OverdraftException(String message, double overdraftAmount) {
		super(message);  //call the super class cotor with the message passed in when the exception was thrown.
		this.overdraftAmount = overdraftAmount;
	}
                                //this exception receives two parameters: a message and the overdraft amount.
	public double getOverdraftAmount() {
		return overdraftAmount;
	}
}
