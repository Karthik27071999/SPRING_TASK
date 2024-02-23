package com.example.appointment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.appointment.entity.serviceprovider;
import com.example.appointment.service.serviceproviderservice;

@RestController
public class serviceprovidercontrol {
	@Autowired
	private serviceproviderservice sps;
	
	@PostMapping("/addservice")
	public String addservice(@RequestBody serviceprovider sp) throws Exception {
		return sps.isAppointmentAvailable(sp);
	}

}
