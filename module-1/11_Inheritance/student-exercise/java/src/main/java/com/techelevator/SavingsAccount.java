package com.techelevator;

public class SavingsAccount extends BankAccount {

public SavingsAccount (String accountHolderName, String accountNumber) {
	super(accountHolderName, accountNumber);
}
public SavingsAccount (String accountHolderName, String accountNumber, int balance) {
	super (accountHolderName, accountNumber, balance); 
}
public int withdraw(int amountToWithdraw) {
	
	if (amountToWithdraw > getBalance()) {
		super.withdraw(0);
		return getBalance();
	}
	if ((getBalance() >= 0) && ((getBalance()) - amountToWithdraw) < 150) {
		super.withdraw(amountToWithdraw + 2);
		return getBalance();
	} else {
		super.withdraw(amountToWithdraw);
		return getBalance();
	}
}
}