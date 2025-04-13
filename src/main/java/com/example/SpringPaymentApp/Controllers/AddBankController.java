package com.example.SpringPaymentApp.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.SpringPaymentApp.entity.BankAccounts;
import com.example.SpringPaymentApp.services.BankService;

import jakarta.servlet.http.HttpSession;
	

@Controller
public class AddBankController 
{
	@Autowired
	BankService bankService;
	
	@GetMapping("/addBankAccount")
	public String addBankAccount(HttpSession session,BankAccounts bankAccounts)
	{
		int id=(int) session.getAttribute("profileid");
		
		bankAccounts.setUserId(id);
		bankAccounts.setWalletAmount(0);
		bankAccounts.setBalanceAmount(10000);
		bankService.addBankAccount(bankAccounts);
		
		return "index";
	}
	
	
	@GetMapping("/sendmoneypage")
	public String sendmoneypage()
	{
		return "sendmoney";
	}


}
