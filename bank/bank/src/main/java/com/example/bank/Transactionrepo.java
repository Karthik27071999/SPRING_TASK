package com.example.bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Transactionrepo extends JpaRepository<Transaction, Long> {

}
