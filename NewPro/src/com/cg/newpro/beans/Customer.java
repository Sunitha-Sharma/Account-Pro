package com.cg.newpro.beans;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {

	@Id
	private String mobileNo;
	private String name;
	
	@Embedded
	private Wallet wallet;

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}

	public Customer(String mobileNo, String name, Wallet wallet) {
		super();
		this.mobileNo = mobileNo;
		this.name = name;
		this.wallet = wallet;
	}

	public Customer() {
		super();
	}

	@Override
	public String toString() {
		return "Customer [mobileNo=" + mobileNo + ", name=" + name + ", wallet=" + wallet + "]";
	}

	
	
	
}
