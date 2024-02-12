package com.example.bank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Exceptionhandling {
	@ExceptionHandler
    public ResponseEntity<String> handleInsufficientBalanceException(InsufficientBalanceException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Insufficient balance: " + e.getMessage());
    }
	@ExceptionHandler
    public ResponseEntity<String> idnotfound(IdNotFound e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("ID NOT FOUND :" + e.getMessage());
    }
	@ExceptionHandler
    public ResponseEntity<String> emailvalid(EmailAlreadyRegistered e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("INVALID EMAIL :" + e.getMessage());
    }


}
