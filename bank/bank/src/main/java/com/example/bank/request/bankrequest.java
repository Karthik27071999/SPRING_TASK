package com.example.bank.request;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class bankrequest {
	private long id;
	private String name;
	private String email;
	private String phonenumber;
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	private bankrequest(long id, String name, String email, String phonenumber) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phonenumber = phonenumber;
	}
	private bankrequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}