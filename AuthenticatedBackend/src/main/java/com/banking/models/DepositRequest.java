package com.banking.models;

public class DepositRequest {
    private String accountType;
    private double amount;
    
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public DepositRequest(String accountType, double amount) {
		super();
		this.accountType = accountType;
		this.amount = amount;
	}
	public DepositRequest() {
		super();
	}
}