package com.example.SpringPaymentApp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Transactions 
{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int transactionId;
  
  private String transactionDate;
  private int sourceId;
  private int targetId;
  private String sourceType;
  private String targetType;
  private double transactionAmount;
  private String transactionType;
  


public String getTransactionType() {
	return transactionType;
}

public void setTransactionType(String transactionType) {
	this.transactionType = transactionType;
}

public Transactions(String transactionDate, int sourceId, int targetId, String sourceType, String targetType,
		double transactionAmount, String transactionType) {
	super();
	this.transactionDate = transactionDate;
	this.sourceId = sourceId;
	this.targetId = targetId;
	this.sourceType = sourceType;
	this.targetType = targetType;
	this.transactionAmount = transactionAmount;
	this.transactionType=transactionType;
}

public Transactions()
{
	
}
public int getTransactionId() {
	return transactionId;
}
public void setTransactionId(int transactionId) {
	this.transactionId = transactionId;
}
public String getTransactionDate() {
	return transactionDate;
}
public void setTransactionDate(String transactionDate) {
	this.transactionDate = transactionDate;
}
public int getSourceId() {
	return sourceId;
}
public void setSourceId(int sourceId) {
	this.sourceId = sourceId;
}
public int getTargetId() {
	return targetId;
}
public void setTargetId(int targetId) {
	this.targetId = targetId;
}
public String getSourceType() {
	return sourceType;
}
public void setSourceType(String sourceType) {
	this.sourceType = sourceType;
}
public String getTargetType() {
	return targetType;
}
public void setTargetType(String targetType) {
	this.targetType = targetType;
}
public double getTransactionAmount() {
	return transactionAmount;
}
public void setTransactionAmount(double transactionAmount) {
	this.transactionAmount = transactionAmount;
}
  
  
  
	
	
}
