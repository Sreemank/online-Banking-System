package com.banking.models;

public class RecipientRequest {
	
	private String amount;
	private String recipientName;
	private String accountType;
	public RecipientRequest(String amount, String recipientName, String accountType) {
		super();
		this.amount = amount;
		this.recipientName = recipientName;
		this.accountType = accountType;
	}
	public RecipientRequest() {
		super();
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getRecipientName() {
		return recipientName;
	}
	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

}
