package com.example.appointment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.appointment.entity.appointment;
import com.example.appointment.service.appointservice;

@RestController
public class appointmentcontrol {
	@Autowired
	private appointservice as;
	
	@PostMapping("/addappointment")
	public appointment addapp(@RequestBody appointment app) {
		return as.add(app);
	}
	
	

}
