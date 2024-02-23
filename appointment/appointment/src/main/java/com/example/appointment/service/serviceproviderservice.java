package com.example.appointment.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.appointment.entity.appointment;
import com.example.appointment.entity.appusers;
import com.example.appointment.entity.serviceprovider;
import com.example.appointment.repo.appointmentrepo;
import com.example.appointment.repo.appusersrepo;
import com.example.appointment.repo.serviceproviderrepo;

@Service
public class serviceproviderservice {
	@Autowired
	private serviceproviderrepo srepo;
	@Autowired
	private appusersrepo arepo;
	@Autowired
	private appointmentrepo apprepo;
	
	
	public String isAppointmentAvailable(serviceprovider spp) throws Exception {
		  boolean isOverlapping = apprepo.existsOverlappingAppointments(
	                spp.getServicename(),
	                spp.getEndTime(),
	                spp.getStartTime()
	        );
		  if(isOverlapping) {
			  return "THE APPOINTMENT TIMING BETWEEN " +spp.getStartTime()+" AND "+spp.getEndTime()+ " FOR "+spp.getServicename()+" IS NOT AVAILABLE.\nPLEASE MAKE ANOTHER TIMING FOR APPOINTMENT..";
		  }
		  else {
		 appusers saveduser=arepo.findById(spp.getAppuser().getId()).orElseThrow(()->new Exception("user not found"));
		  
		  serviceprovider ssp=new serviceprovider();
		  ssp.setAppuser(saveduser);
		  ssp.setContext(spp.getContext());
		  ssp.setEndTime(spp.getEndTime());
		  ssp.setServicename(spp.getServicename());
		  ssp.setStartTime(spp.getStartTime());
		  serviceprovider savedser=srepo.save(ssp);
		  
		  appointment appo=new appointment();
		  appo.setAppuser(saveduser);
		  appo.setEndTime(savedser.getEndTime());
		  appo.setSp(savedser);
		  appo.setStartTime(savedser.getStartTime());
		  appo.setStatus("CONFIRMED");
		  apprepo.save(appo);
		  return "APPOINTMENT CONFIRMED WITH THE TIMING YOU HAVE MENTIONED. KINDLY BE AVAILABLE BEFORE 10 MINUTES..\nTHANK YOU..";
		  }
		 
	 
	  
	  

}}
