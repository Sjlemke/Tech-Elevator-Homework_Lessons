package com.techelevator;

/**
 * CreditCardAccount
 */
public class CreditCardAccount implements Accountable {
	
/*******************************************************************
 * Place the code for  your CreditCard class here
 
  
 *******************************************************************/
private String accountHolder;
private String accountNumber;
private int debt;

public CreditCardAccount(String accountHolder, String accountNumber) {
	this.accountHolder = accountHolder;
	this.accountNumber = accountNumber;
	debt = 0;
}

public String getAccountHolder() {
	return accountHolder;
}
public String getAccountNumber() {
	return accountNumber;
}
public int getDebt() {
    return debt;

}

public int charge(int amountToCharge) {
		debt = debt + amountToCharge;
				return debt;
	}
public int pay(int amountToPay) {
	   debt = debt - amountToPay;
	           return debt; 
}

    public int getBalance() {
    	
        return 0 - debt ;
    }

 

}