package com.cg.newpro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cg.newpro.beans.Customer;
import com.cg.newpro.exceptions.AccountAlreadyExistsException;
import com.cg.newpro.exceptions.InsertFailedException;
import com.cg.newpro.services.WalletService;

@Controller
public class ActionController {
	
	@Autowired
	WalletService service;
	
	@RequestMapping(value="/")
	public String getIndexPage() {
		return "index";
	}
	
	@RequestMapping(value="create")
	public String createPage()
	{
		return "CreateAccount";
	}
	
	@RequestMapping(value="withdraw")
	public String getWithdraw()
	{
		return "withdraw";
	}

@ModelAttribute("cust")
public Customer custfunc()
{
	return new Customer();
}

@RequestMapping(value="createAcc")
public ModelAndView createAccount(@ModelAttribute("cust") Customer cust)
{
	Customer temp = null;
	try {
		temp=service.createAccount(cust.getMobileNo(), cust.getName(),cust.getWallet().getBalance());
		
		
	} catch (InsertFailedException | AccountAlreadyExistsException e) {
		
		e.printStackTrace();
	}
		return new ModelAndView("SuccessPage", "cust1", temp);
	
	}
	
}
