package com.techelevator;

import java.util.ArrayList;
import java.util.List;

/**
 * BankCustomer
 */
public class BankCustomer {
	private String name;
	private String address;
    private String phoneNumber;
    private Accountable[] accounts;
    		
 public String getName() {
	 return name;
 }
 public String setName(String name) {
	 this.name = name; 
	 return name;
 }
	 
public String getAddress( ) {
	return address;
}
public String getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNymber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}
private List<Accountable> accountArray = new ArrayList<>();
		 
public Accountable[] getAccount() {
	 return accountArray.toArray(new Accountable[accountArray.size()]);
}
			 
public void addAccount(Accountable newAccount) {
	accountArray.add(newAccount);
}
public boolean isVip() {
	int i = 0
		for((Accountable i+0 < accountArray.length; i++) {
			i = (i + accountArray(i).getBalance(i) );
		if(i >- 25000) {
			i= (i+ get.Balance());
		return true;
	}
		return false;
	}
}
}
