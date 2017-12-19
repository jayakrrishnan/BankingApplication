package com.training.entity;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class Transaction {

	private long transactionId;
	private double amount;
	private long fromAccount;
	private long toAccount;
	private Date date;
	public Transaction() {
		super();
		
	}
	public Transaction(double amount, long fromAccount, long toAccount, Date date) {
		super();
		
		this.amount = amount;
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.date = date;
	}
	public long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public long getFromAccount() {
		return fromAccount;
	}
	public void setFromAccount(long fromAccount) {
		this.fromAccount = fromAccount;
	}
	public long getToAccount() {
		return toAccount;
	}
	public void setToAccount(long toAccount) {
		this.toAccount = toAccount;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", amount=" + amount + ", fromAccount=" + fromAccount
				+ ", toAccount=" + toAccount + ", date=" + date + "]";
	}
		
}
