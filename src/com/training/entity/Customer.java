package com.training.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Customer extends User{

	private String customerName;

	private String addressLine1;
	private String addressLine2;
	private String city;
	private long zipCode;
	
	private long mobileNumber;
	private String email;
	private long accountNumber;
	private String accountType;
	private String branchName;
	private double balance;

	public Customer() {
		super();

	}

	public Customer( String userName, String passWord, String customerName, String addressLine1,
			String addressLine2, String city, long zipCode, long mobileNumber, String email, long accountNumber,
			String accountType, String branchName, double balance) {
		super(userName, passWord);
		this.customerName = customerName;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.zipCode = zipCode;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.branchName = branchName;
		this.balance = balance;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public long getZipCode() {
		return zipCode;
	}

	public void setZipCode(long zipCode) {
		this.zipCode = zipCode;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Customer [customerName=" + customerName + ", addressLine1=" + addressLine1 + ", addressLine2="
				+ addressLine2 + ", city=" + city + ", zipCode=" + zipCode + ", mobileNumber=" + mobileNumber
				+ ", email=" + email + ", accountNumber=" + accountNumber + ", accountType=" + accountType
				+ ", branchName=" + branchName + ", balance=" + balance + "]";
	}

	

	
	

}
