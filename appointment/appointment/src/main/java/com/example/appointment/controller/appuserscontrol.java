package com.example.appointment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.appointment.entity.appusers;
import com.example.appointment.service.appusersservice;

@RestController
public class appuserscontrol {
	@Autowired
	private appusersservice aus;
	
	@PostMapping("/adduser")
	public appusers addusers(@RequestBody appusers user) {
		return aus.add(user);
	}

}
