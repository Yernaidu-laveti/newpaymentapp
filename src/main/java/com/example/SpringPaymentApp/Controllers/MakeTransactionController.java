package com.example.SpringPaymentApp.Controllers;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.SpringPaymentApp.entity.BankAccounts;
import com.example.SpringPaymentApp.entity.Transactions;
import com.example.SpringPaymentApp.services.BankService;
import com.example.SpringPaymentApp.services.TransactionsService;

@Controller
public class MakeTransactionController 
{
	@Autowired
	TransactionsService transserv;
	
	@Autowired
	BankService serv;
	
	@GetMapping("/sendmoney")
	public String sendMoney(Transactions tansactions)
	{
		int sourceId=tansactions.getSourceId();
		int targetId=tansactions.getTargetId();

		BankAccounts sourceaccount=serv.getAccount(String.valueOf(sourceId));  // sender account
		BankAccounts targetaccount=serv.getAccount(String.valueOf(targetId));  // receiver account
		double trasactionAmount=tansactions.getTransactionAmount();				// transaction amount
		String sType=tansactions.getSourceType();								// sending type
		String tType=tansactions.getTargetType();  //to type
		if(sType.equals("bank"))
		{
			if(trasactionAmount>sourceaccount.getBalanceAmount())
			{
				return "sendmoney";
			}
			else
			{
				if(tType.equals("bank"))
				{
					double balance=trasactionAmount+targetaccount.getBalanceAmount();
					serv.updatebalance(tansactions.getTargetId(),balance);
					balance=sourceaccount.getBalanceAmount()-trasactionAmount;
					serv.updatebalance(tansactions.getSourceId(),balance);
					
					
				}
				else
				{
					
					double walletbalance=trasactionAmount+targetaccount.getWalletAmount();
					serv.updatewallet(tansactions.getTargetId(),walletbalance);
					walletbalance=sourceaccount.getBalanceAmount()-trasactionAmount;
					serv.updatebalance(tansactions.getSourceId(),walletbalance);
					
				}
			}
			
		}
		else
		{
			if(trasactionAmount>sourceaccount.getWalletAmount())
			{
				return "sendmoney";
			}
			else
			{
				if(tType.equals("bank"))
				{
					double walletbalance=trasactionAmount+targetaccount.getBalanceAmount();
					serv.updatebalance(tansactions.getTargetId(),walletbalance);
					walletbalance=sourceaccount.getWalletAmount()-trasactionAmount;
					serv.updatewallet(tansactions.getSourceId(),walletbalance);
					
					
				}
				else
				{
					double walletbalance=trasactionAmount+targetaccount.getWalletAmount();
					serv.updatewallet(tansactions.getTargetId(),walletbalance);
					walletbalance=sourceaccount.getWalletAmount()-trasactionAmount;
					serv.updatewallet(tansactions.getSourceId(),walletbalance);
					
				}
			}
		}
		
		
		LocalDate myObj = LocalDate.now(); 
		tansactions.setTransactionDate(String.valueOf(myObj));
		tansactions.setTransactionType("debit");
		transserv.sendMoney(tansactions);
		
		Transactions trans=new Transactions();
		trans.setTransactionDate(String.valueOf(myObj));
		trans.setSourceId(targetId);
		trans.setTargetId(sourceId);
		
		trans.setSourceType(tType);
		trans.setTargetType(sType);
		trans.setTransactionAmount(trasactionAmount);
		trans.setTransactionType("credit");
		transserv.sendMoney(trans);
		
		return "sendmoney";
		
		
		
		
//		 private String transactionDate;
//		  private int sourceId;
//		  private int targetId;
//		  private String sourceType;
//		  private String targetType;
//		  private double transactionAmount;
//		  private String transactionType;
	}
	
	  @GetMapping("/transactionpage")
		public String transactionPage(Model model)
		{
			ArrayList<Transactions> transaction=transserv.getTenTransactions();
			model.addAttribute("tentransaction", transaction);
			for(Transactions tr:transaction)
			{
			System.out.println(tr.getSourceId());
			}
			return "history";
		}
	  
	  @PostMapping("/generateStatement")
	  public String transactions(Model model,@RequestParam("filters") String[] filter,@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate)
	  {
		  ArrayList<Transactions> transaction=new ArrayList<Transactions>();
		  if(filter.length==1)
		  {
			  
			  transaction=transserv.singleselectiontransactions(filter,startDate,endDate);
		  }
		  else if(filter.length==2)
		  {
			  transaction=transserv.doubleselectiontransactions(filter,startDate,endDate);
		  }
		  else if(filter.length==3)
		  {
			  transaction=transserv.tripleselectiontransactions(filter,startDate,endDate);
		  }
		 
			model.addAttribute("tentransaction", transaction);
			for(Transactions tr:transaction)
			{
			System.out.println(tr.getSourceId());
			}
			//System.out.println(filter.length);
			return "history";
	  }

	
	

}

//private int transactionId;
//
//private String transactionDate;
//private int sourceId;
//private int targetId;
//private String sourceType;
//private String targetType;
//private double transactionAmount;