package com.example.SpringPaymentApp.Controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String addBankAccount(HttpSession session,BankAccounts bankAccounts,Model model)
	{
		
		int id=(int) session.getAttribute("profileid");
		BankAccounts found=new BankAccounts();
		found=bankService.getAccount(bankAccounts.getAccountNumber());
		if(found!=null)
		{
			model.addAttribute("msg","Account already Exists");
			System.out.println("hii");
			//int id=(int)session.getAttribute("profileid");
			ArrayList<BankAccounts> accounts=new ArrayList<BankAccounts>();
			accounts=bankService.getAccounts(id);
			model.addAttribute("bankaccounts",accounts);
			return "index";
		}
		else
		{
		bankAccounts.setUserId(id);
		bankAccounts.setWalletAmount(0);
		bankAccounts.setBalanceAmount(10000);
		bankService.addBankAccount(bankAccounts);
		model.addAttribute("msg","Account Added Successfully");
		ArrayList<BankAccounts> accounts=new ArrayList<BankAccounts>();
		accounts=bankService.getAccounts(id);
		model.addAttribute("bankaccounts",accounts);
		return "index";
		}
		
		
		
	}
	
	
	@GetMapping("/sendmoneypage")
	public String sendmoneypage(HttpSession session,Model model)
	{
		int id=(int)session.getAttribute("profileid");
		ArrayList<BankAccounts> accounts=new ArrayList<BankAccounts>();
		accounts=bankService.getAccounts(id);
		model.addAttribute("bankaccounts",accounts);
		return "sendmoney";
	}
	
	
	@GetMapping("/indexpage")
	public String indexpage(HttpSession session,Model model)
	{
		int id=(int)session.getAttribute("profileid");
		ArrayList<BankAccounts> accounts=new ArrayList<BankAccounts>();
		accounts=bankService.getAccounts(id);
		model.addAttribute("bankaccounts",accounts);
		return "index";
		
	}


}
