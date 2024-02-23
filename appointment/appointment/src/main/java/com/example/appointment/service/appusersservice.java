package com.example.appointment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.appointment.entity.appusers;
import com.example.appointment.repo.appusersrepo;

@Service
public class appusersservice {
	@Autowired
	private appusersrepo urepo;
	
	public appusers add(appusers ap) {
		return urepo.save(ap);
	}

}
