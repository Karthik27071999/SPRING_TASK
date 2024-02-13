package com.example.bank.request;

public class Accountreq {
	private String account;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	private Accountreq(String account) {
		super();
		this.account = account;
	}

	private Accountreq() {
		super();
		// TODO Auto-generated constructor stub
	}


	

}
