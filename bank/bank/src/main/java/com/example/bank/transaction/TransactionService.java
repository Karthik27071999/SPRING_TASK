package com.example.bank.transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bank.bankent;
import com.example.bank.bankrepo;
import com.example.bank.exception.IdNotFound;
import com.example.bank.exception.InsufficientBalanceException;

import jakarta.transaction.Transactional;

@Service
public class TransactionService {
	@Autowired
	private bankrepo repo;
	@Autowired
	private Transactionrepo tr;

	@Transactional
	public Transaction credit(long id, BigDecimal amount) throws Exception {
		bankent en=repo.findById(id).orElseThrow(()-> new Exception("ACCOUNT NOT FOUND"));
		BigDecimal balan=en.getBalance().add(amount);
		en.setBalance(balan);
		repo.save(en);
		Transaction tt=new Transaction();
		
		tt.setAccount(en.getAccount());
		tt.setAmount(amount);
		tt.setTime(LocalDateTime.now());
		tt.setTransactiontype("CREDIT");
		return tr.save(tt);
		
	}
	@Transactional
	public Transaction debit(long id, BigDecimal amount) throws Exception {
		bankent en=repo.findById(id).orElseThrow(()->new IdNotFound("THE ID YOU ENTERED IS NOT FOUND. PLEASE ENTER VALID ID!"));
		
		BigDecimal balance=en.getBalance().subtract(amount);
		 if (balance.compareTo(BigDecimal.ZERO) < 0) {
	            throw new InsufficientBalanceException("YOUR BALANCE IS INSUFFICIENT TO WITHDRAW THE AMOUNT");
	        }
		en.setBalance(balance);
		repo.save(en);
		Transaction tt=new Transaction();
		
		tt.setAccount(en.getAccount());
		tt.setAmount(amount);
		tt.setTime(LocalDateTime.now());
		tt.setTransactiontype("DEBIT");
		return tr.save(tt);
	}
	public List<Transaction> getalldetail(){
		return tr.findAll();
	}
	public List<Transaction> getbyaccount(String account){
		return tr.findByAccount(account);
	}

	

}
