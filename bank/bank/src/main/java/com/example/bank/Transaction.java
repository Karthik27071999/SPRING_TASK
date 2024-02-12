package com.example.bank;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Transaction {
	@Id
	private long transaction_id;
	private BigDecimal amount;
	private LocalDateTime time;
	private String transactiontype;
	public long getTransaction_id() {
		return transaction_id;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public LocalDateTime getTime() {
		return time;
	}
	public String getTransactiontype() {
		return transactiontype;
	}
	public void setTransaction_id(long transaction_id) {
		this.transaction_id = transaction_id;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	public void setTransactiontype(String transactiontype) {
		this.transactiontype = transactiontype;
	}
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	private Transaction(long transaction_id, BigDecimal amount, LocalDateTime time, String transactiontype) {
		super();
		this.transaction_id = transaction_id;
		this.amount = amount;
		this.time = time;
		this.transactiontype = transactiontype;
	}
	

	
	

}
