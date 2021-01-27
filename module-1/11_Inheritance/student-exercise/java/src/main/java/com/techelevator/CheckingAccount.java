package com.techelevator;

public class CheckingAccount extends BankAccount{

	public CheckingAccount(String accountHolder, String accountNumber, int balance) {
		super(accountHolder, accountNumber, balance);
	}
	
	public CheckingAccount(String accountHolder, String accountNumber) {
		super(accountHolder, accountNumber, 0);
	}
    public int withdraw(int amountToWithdraw) {
    	int balance = getBalance() - amountToWithdraw;
    	if (balance < 0 && balance > -100) {
    	super.withdraw(amountToWithdraw); 
    	super.withdraw(10);
    	}
    	if (balance <= -100) {
    		return getBalance();
    	} else {
    		super.withdraw(amountToWithdraw);
    		return getBalance();
    	}	
    	}
	}
	

