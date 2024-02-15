package com.example.bank.request;

public class Accountreq {
	private String account;
	private String email;
	public String getAccount() {
		return account;
	}
	public String getEmail() {
		return email;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	private Accountreq(String account, String email) {
		super();
		this.account = account;
		this.email = email;
	}
	private Accountreq() {
		super();
		// TODO Auto-generated constructor stub
	}




	

}
