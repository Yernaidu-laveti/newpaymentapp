package com.example.SpringPaymentApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.SpringPaymentApp.User;
import com.example.SpringPaymentApp.entity.BankAccounts;

import jakarta.transaction.Transactional;

public interface BankRepository extends  JpaRepository<BankAccounts,Integer> 
{
	BankAccounts findByUserId(int userId);

	BankAccounts findByAccountNumber(String accountNumber);
	
	@Modifying
    @Transactional
    @Query("UPDATE BankAccounts b SET b.balanceAmount = :targetBalance WHERE b.accountNumber = :accountNumber")
    void updateBalance(@Param("accountNumber") int accountNumber, @Param("targetBalance") double targetBalance);
	
	@Modifying
	@Transactional
	@Query("UPDATE BankAccounts b SET b.walletAmount=:walletAmount where  b.accountNumber = :accountNumber")
	 void updateWallet(@Param("accountNumber") int accountNumber, @Param("walletAmount") double walletAmount);

}
