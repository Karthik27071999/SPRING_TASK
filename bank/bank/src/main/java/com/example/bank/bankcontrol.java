package com.example.bank;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class bankcontrol {
	@Autowired
	private bankservice service;
	@Autowired
	private TransactionService ss;
	
	@PostMapping("/adduser")
	public bankent in(@RequestBody bankrequest req) {
		return service.added(req);
		
	}
	@GetMapping("/users")
	public List<bankent> get() {
		return service.getall();
	}
	@PostMapping("/credit/{id}")
	public Transaction credit(@PathVariable long id,@RequestBody Transaction tt) throws Exception {
		return ss.credit(id, tt.getAmount());
	}
	@PostMapping("/debit/{id}")
	public Transaction debit(@PathVariable long id,@RequestBody Transaction tt) throws Exception {
		return ss.debit(id, tt.getAmount());
	}

}
