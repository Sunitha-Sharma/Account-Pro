package com.cg.newpro.services;

import java.math.BigDecimal;

import com.cg.newpro.beans.Customer;
import com.cg.newpro.exceptions.AccountAlreadyExistsException;
import com.cg.newpro.exceptions.InsertFailedException;

public interface WalletService {
	
	public Customer createAccount(String mobileNo,String name,BigDecimal amount) throws InsertFailedException, AccountAlreadyExistsException;
	public boolean withdraw(String mobileNo,BigDecimal amount) throws InsertFailedException;
	public Customer fundTransfer(String srcMobileNo,String trMobileNo,BigDecimal amount);
}
