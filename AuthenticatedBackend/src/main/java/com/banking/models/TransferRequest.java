package com.banking.models;

public class TransferRequest {

	private String transferFrom;
	private String transferTo;
	private String amount;
	public TransferRequest(String transferFrom, String transferTo, String amount) {
		super();
		this.transferFrom = transferFrom;
		this.transferTo = transferTo;
		this.amount = amount;
	}
	public TransferRequest() {
		super();
	}
	public String getTransferFrom() {
		return transferFrom;
	}
	public void setTransferFrom(String transferFrom) {
		this.transferFrom = transferFrom;
	}
	public String getTransferTo() {
		return transferTo;
	}
	public void setTransferTo(String transferTo) {
		this.transferTo = transferTo;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
}
