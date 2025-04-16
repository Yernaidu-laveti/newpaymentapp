package com.example.SpringPaymentApp.services;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.SpringPaymentApp.entity.Transactions;
import com.example.SpringPaymentApp.repository.TransactionRepository;

@Service
public class TransactionsService {

	@Autowired
	TransactionRepository transRepo;
	

	public void sendMoney(Transactions tansactions) 
	{
		
		
		transRepo.save(tansactions);
		
	}


public ArrayList<Transactions> getTenTransactions() {
	
		ArrayList<Transactions> result=transRepo.findAll();
		return result;
		
	}


public ArrayList<Transactions> transactions() {
	ArrayList<Transactions> result=transRepo.findAll();
	return result;
}


public ArrayList<Transactions> singleselectiontransactions(String[] filter,String startDate, String endDate) 
{
	ArrayList<Transactions> result=new ArrayList<Transactions>();
	if(filter[0].equals("all"))
	{
		//result=transRepo.findAllByDateRange(new Date(startDate),new Date(endDate));
		result=transRepo.findAllByDateRange(startDate,endDate);
	}
	else if(filter[0].equals("bank"))
	{
		String bank="bank";
		result=transRepo.findAllByDateRangeWithBankTransactions(bank,startDate,endDate);
	}
	else if(filter[0].equals("wallet"))
	{
		String wallet="wallet";
		result=transRepo.findAllByDateRangeWithBankTransactions(wallet,startDate,endDate);
	}
	else if(filter[0].equals("credit"))
	{
		String credit="credit";
		result=transRepo.findAllByDateRangeWithBankTransactions(credit,startDate,endDate);
	}
	else if(filter[0].equals("debit"))
	{
		String debit="debit";
		result=transRepo.findAllByDateRangeWithBankTransactions(debit,startDate,endDate);
	}
	
	return result;
}


public ArrayList<Transactions> doubleselectiontransactions(String[] filter, String startDate, String endDate)
{
	
	ArrayList<Transactions> result=new ArrayList<Transactions>();
	if((filter[0].equals("wallet") || filter[0].equals("bank")) && (filter[1].equals("wallet") || filter[1].equals("bank")) )
	{
		String bank="wallet";
		String wallet="bank";
		System.out.println(filter[0]+" "+filter[1]);
		result=transRepo.findAllByDateRangeAndWalletAndBank(startDate,endDate,bank,wallet);
	}
	else if((filter[0].equals("credit") || filter[0].equals("debit")) && (filter[1].equals("credit") || filter[1].equals("debit")) )
	{
		String bank="credit";
		String wallet="debit";
		System.out.println(filter[0]+" "+filter[1]);
		result=transRepo.findAllByDateRangeAndCreditAndDebit(startDate,endDate,bank,wallet);
	}
	else if((filter[0].equals("credit") || filter[0].equals("wallet")) && (filter[1].equals("credit") || filter[1].equals("wallet")) )
	{
		String bank="wallet";
		String wallet="credit";
		System.out.println(filter[0]+" "+filter[1]);
		result=transRepo. findAllByDateRangeAndSourceAndTransaction(startDate,endDate,bank,wallet);
	}
	else if((filter[0].equals("credit") || filter[0].equals("bank")) && (filter[1].equals("credit") || filter[1].equals("bank")) )
	{
		String bank="bank";
		String wallet="credit";
		System.out.println(filter[0]+" "+filter[1]);
		result=transRepo. findAllByDateRangeAndSourceAndTransaction(startDate,endDate,bank,wallet);
	}
	else if((filter[0].equals("debit") || filter[0].equals("wallet")) && (filter[1].equals("debit") || filter[1].equals("wallet")))
	{
		String bank="wallet";
		String wallet="debit";
		System.out.println(filter[0]+" "+filter[1]);
		result=transRepo.findAllByDateRangeAndSourceAndTransaction(startDate,endDate,bank,wallet);
	}
	else if((filter[0].equals("debit") || filter[0].equals("bank")) && (filter[1].equals("debit") || filter[1].equals("bank")))
	{
		String bank="bank";
		String wallet="debit";
		System.out.println(filter[0]+" "+filter[1]);
		result=transRepo.findAllByDateRangeAndSourceAndTransaction(startDate,endDate,bank,wallet);
	}
	
	return result;
}


public ArrayList<Transactions> tripleselectiontransactions(String[] filter, String startDate, String endDate) {
	ArrayList<Transactions> result=new ArrayList<Transactions>();
	Arrays.sort(filter);
	
	if(filter[0].equals("bank") && filter[1].equals("credit") && filter[2].equals("wallet"))
	{
		
		String wallet="wallet";
		String bank="bank";
		String debit="debit";
		result=transRepo.findAllByDateRangeAndWalletAndBankAndType(startDate,endDate,bank,wallet,debit);
	}
	else if(filter[0].equals("bank") && filter[1].equals("debit") && filter[2].equals("wallet"))
	{
		
		String debit="credit";
		String bank="bank";
		String wallet="wallet";
		result=transRepo.findAllByDateRangeAndWalletAndBankAndType(startDate,endDate,bank,wallet,debit);
	}
	else if(filter[0].equals("bank") && filter[1].equals("credit") && filter[2].equals("debit"))
	{
		
		String credit="credit";
		String bank="bank";
		String debit="debit";
		result=transRepo.findAllByDateRangeAndCreditAndDebitAndType(startDate,endDate,bank,credit,debit);
	}
	else if(filter[0].equals("credit") && filter[1].equals("debit") && filter[2].equals("wallet"))
	{
		
		String credit="credit";
		String bank="wallet";
		String debit="debit";
		result=transRepo.findAllByDateRangeAndCreditAndDebitAndType(startDate,endDate,bank,credit,debit);
	}
	
	
	
	
	return result;
}
	

}
