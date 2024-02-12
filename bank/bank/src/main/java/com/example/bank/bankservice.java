package com.example.bank;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bank.exception.EmailAlreadyRegistered;
@Service
public class bankservice {
	@Autowired
	private bankrepo repo;
	
	public bankent added(bankrequest req) {
		if(repo.existsByemail( req.getEmail())) {
			throw new EmailAlreadyRegistered("THIS EMAIL IS ALREADY REGISTERD,PLEASE ENTER ANOTHER EMAIL TO CREATE NEW ACCOUNT");
		}
		else {
			bankent en =new bankent();
		en.setId(req.getId());
		en.setName(req.getName());
		en.setEmail(req.getEmail());
		en.setBalance(BigDecimal.ZERO);
		en.setAccount(Accountnum.createaccnum());
		 return repo.save(en) ;
		}
		
	}
	public List<bankent> getall() {
		return repo.findAll();
	}

}
