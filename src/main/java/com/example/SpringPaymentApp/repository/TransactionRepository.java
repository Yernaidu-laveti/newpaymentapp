package com.example.SpringPaymentApp.repository;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.SpringPaymentApp.entity.Transactions;

public interface TransactionRepository extends JpaRepository<Transactions,Integer>
{

	// Page<Transactions> findAll(Pageable pageable); 
	 
	 ArrayList<Transactions> findAll();
	 
	 @Query("SELECT t FROM Transactions t WHERE t.transactionDate >= :startDate AND t.transactionDate <= :endDate")
	 ArrayList<Transactions> findAllByDateRange(@Param("startDate") String startDate, @Param("endDate") String endDate);
	 
	@Query("SELECT t FROM Transactions t WHERE t.transactionDate >=:startDate AND t.transactionDate <=:endDate AND sourceType=:bank")
	ArrayList<Transactions> findAllByDateRangeWithBankTransactions(@Param("bank") String bank,@Param("startDate") String startDate, @Param("endDate") String endDate);
   
	//@Query("SELECT t FROM Transactions t WHERE t.transactionDate >=:startDate AND t.transactionDate <=:endDate AND sourceType=:wallet")
	//ArrayList<Transactions> findAllByDateRangeWithWalletTransactions(@Param("wallet") String wallet,@Param("startDate") String startDate, @Param("endDate") String endDate);

	
	@Query("SELECT t FROM Transactions t WHERE t.transactionDate >=:startDate AND t.transactionDate<=:endDate AND (t.sourceType=:bank  OR t.sourceType=:wallet)")
	ArrayList<Transactions> findAllByDateRangeAndWalletAndBank(@Param("startDate") String startDate, @Param("endDate") String endDate,@Param("bank") String bank, @Param("wallet") String wallet);

	@Query("SELECT t FROM Transactions t WHERE t.transactionDate >=:startDate AND t.transactionDate<=:endDate AND (t.transactionType=:bank  OR t.transactionType=:wallet)")
	ArrayList<Transactions> findAllByDateRangeAndCreditAndDebit(@Param("startDate") String startDate, @Param("endDate") String endDate,@Param("bank") String bank, @Param("wallet") String wallet);
	
	@Query("SELECT t FROM Transactions t WHERE t.transactionDate >=:startDate AND t.transactionDate<=:endDate AND (t.sourceType=:bank  AND t.transactionType=:wallet)")
	ArrayList<Transactions> findAllByDateRangeAndSourceAndTransaction(@Param("startDate") String startDate, @Param("endDate") String endDate,@Param("bank") String bank, @Param("wallet") String wallet);
	
	
	// Triple selection
	@Query("SELECT t FROM Transactions t WHERE t.transactionDate >=:startDate AND t.transactionDate<=:endDate AND (t.sourceType=:bank  OR t.sourceType=:wallet) AND (t.transactionType=:debit)")
	ArrayList<Transactions> findAllByDateRangeAndWalletAndBankAndType(String startDate, String endDate, String bank,
			String wallet, String debit);
	
	
	@Query("SELECT t FROM Transactions t WHERE t.transactionDate >=:startDate AND t.transactionDate<=:endDate AND (t.sourceType=:bank) AND (t.transactionType=:credit OR t.transactionType=:debit)")
		ArrayList<Transactions> findAllByDateRangeAndCreditAndDebitAndType(String startDate, String endDate, String bank,
			String credit, String debit);

	


}
