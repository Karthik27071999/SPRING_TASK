package com.example.bank;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.example.bank.exception.EmailAlreadyRegistered;
import com.twilio.exception.ApiException;
@Service
public class bankservice {
	@Autowired
	private bankrepo repo;
	 @Autowired
	    private SmsNotificationService smsNotificationService;
	
	
	public bankent added(bankrequest req) {
		if(repo.existsByemail( req.getEmail())) {
			throw new EmailAlreadyRegistered("THIS EMAIL IS ALREADY REGISTERD,PLEASE ENTER ANOTHER EMAIL TO CREATE NEW ACCOUNT");
		}
		else {
			try {
	            
	            String recipientPhoneNumber = req.getPhonenumber();
	            String messageBody = "Your account has been successfully created. Welcome to our platform!";
	            smsNotificationService.sendSmsNotification(recipientPhoneNumber, messageBody);
	        } catch (ApiException e) {
	            
	            System.err.println("Failed to send SMS notification: " + e.getMessage());
	        }
			bankent en =new bankent();
		en.setId(req.getId());
		en.setName(req.getName());
		en.setEmail(req.getEmail());
		en.setBalance(BigDecimal.ZERO);
		en.setPhonenumber(req.getPhonenumber());
		en.setAccount(Accountnum.createaccnum());
		 return repo.save(en) ;
		}
	}

	public List<bankent> getall() {
		return repo.findAll();
	}

}