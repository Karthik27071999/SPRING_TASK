package com.example.bank.transaction;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface Transactionrepo extends JpaRepository<Transaction, Long> {
	@Query
	List<Transaction> findByAccount(String account);
}
