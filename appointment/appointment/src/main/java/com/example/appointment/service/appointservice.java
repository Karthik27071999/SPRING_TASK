package com.example.appointment.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.appointment.entity.appointment;
import com.example.appointment.entity.appusers;
import com.example.appointment.entity.serviceprovider;
import com.example.appointment.repo.appointmentrepo;
import com.example.appointment.repo.appusersrepo;
import com.example.appointment.repo.serviceproviderrepo;

@Service
public class appointservice {
	@Autowired
	private appointmentrepo arepo;
	@Autowired
	private appusersrepo apprepo;
	@Autowired
	private serviceproviderrepo servicerepo;
	
	
	public appointment add(appointment app) {
		return arepo.save(app);
	  


}}
