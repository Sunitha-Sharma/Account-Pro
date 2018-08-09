package com.cg.newpro.services;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.newpro.beans.Customer;
import com.cg.newpro.beans.Wallet;
import com.cg.newpro.exceptions.AccountAlreadyExistsException;
import com.cg.newpro.exceptions.InsertFailedException;
import com.cg.newpro.repo.WalletRepo;

@Service
public class WalletServiceImpl implements WalletService {
	
	@Autowired
	WalletRepo repo;

	@Override
	public Customer createAccount(String mobileNo, String name, BigDecimal amount) throws InsertFailedException, AccountAlreadyExistsException {
		
		if(repo.findOne(mobileNo) != null)
		{
			throw new AccountAlreadyExistsException("Account already exists!");
		}
		else
		{
		Customer cust=new Customer(mobileNo, name, new Wallet(amount));
		/*Wallet wallet=new Wallet();
		wallet.setBalance(amount);
		cust.setMobileNo(mobileNo);
		cust.setName(name);
		cust.setWallet(wallet);
		*/
		if(repo.save(cust)!=null)
		{
			return cust;
		}
		else
			throw new InsertFailedException("Account is not created");
	}
	}

	@Override
	public boolean withdraw(String mobileNo, BigDecimal amount) throws InsertFailedException {
		Customer cust=repo.findOne(mobileNo);
		if(cust!=null)
		{
			//BigDecimal amt=cust.getWallet().getBalance();
			if(cust.getWallet().getBalance().compareTo(amount)>0)
			{
				
			/*	BigDecimal bal=amt.subtract(amount);
				cust.getWallet().setBalance(bal);*/
				cust.getWallet().setBalance(cust.getWallet().getBalance().subtract(amount));
				if(repo.save(cust)!=null)
				{
					return true;
				}
				else
					throw new InsertFailedException("Withdraw was not successful");
			}
		}
		return false;
	}

	@Override
	public Customer fundTransfer(String srcMobileNo, String trMobileNo, BigDecimal amount) {
		
		return null;
	}

}
