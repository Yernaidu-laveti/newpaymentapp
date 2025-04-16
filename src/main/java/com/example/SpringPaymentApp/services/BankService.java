package com.example.SpringPaymentApp.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringPaymentApp.entity.BankAccounts;
import com.example.SpringPaymentApp.repository.BankRepository;

@Service
public class BankService 
{
	@Autowired
	BankRepository bankrepository;
	
	public void addBankAccount(BankAccounts bankAccounts) 
	{
		bankrepository.save(bankAccounts);
	}
	
	public ArrayList<BankAccounts> getAccounts(int id) {
		// TODO Auto-generated method stub
		ArrayList<BankAccounts> accounts=new ArrayList<BankAccounts>() ;
		accounts=bankrepository.findByUserId(id);
		return accounts;
	}

	public BankAccounts getAccount(String accountNumber) {
		// TODO Auto-generated method stub
		BankAccounts accounts=null;
		accounts=bankrepository.findByAccountNumber(accountNumber);
		 return accounts;
	}

	public void updatebalance(int accountNumber, double targetBalance) {
		
		bankrepository.updateBalance(accountNumber,targetBalance);
		
	}

public void updatewallet(int accountNumber, double walletAmount) {
		
		bankrepository.updateWallet(accountNumber,walletAmount);
		
	}

//public boolean findAccount(String id) {
//	
//	return bankrepository.findByAccountNumber(id);
//}

	
	
	
}
