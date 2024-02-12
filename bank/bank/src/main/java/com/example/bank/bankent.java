package com.example.bank;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
@Entity
@Builder
@Data
public class bankent {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String name;
	private String email;
	private String account;
	private BigDecimal balance;
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getAccount() {
		return account;
	}
	public BigDecimal getBalance() {
		return balance;
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
	public void setAccount(String account) {
		this.account = account;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	private bankent(long id, String name, String email, String account, BigDecimal balance) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.account = account;
		this.balance = balance;
	}
	bankent() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

}
