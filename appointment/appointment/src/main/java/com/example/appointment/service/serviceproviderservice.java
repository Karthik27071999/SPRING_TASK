package com.example.appointment.service;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
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
	@Autowired
    private JavaMailSender javaMailSender;
 
	
	
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
		  appo.setRemind_status("TO BE REMIND");
		  
		  apprepo.save(appo);
		  return "APPOINTMENT CONFIRMED WITH THE TIMING YOU HAVE MENTIONED. KINDLY BE AVAILABLE BEFORE 10 MINUTES..\nTHANK YOU..";
		  }
	}
	 @Scheduled(fixedRate = 60000) // Run every minute
	    public void sendAppointmentReminders() throws Exception {
	        LocalDateTime currentTime = LocalDateTime.now();
	        LocalDateTime reminderTime = currentTime.plusMinutes(30); // 30 minutes before the appointment

	        List<appointment> appointments = apprepo.findUpcomingAppointments(currentTime, reminderTime);

	        for (appointment appointment : appointments) {
	        	if("TO BE REMIND".equals(appointment.getRemind_status())) {
	        	
	            sendReminderEmail(appointment);
	            appointment.setRemind_status("REMINDED");
	            apprepo.save(appointment);
//	            appusers reminduser=arepo.findById(appointment.getAppuser().getId()).orElseThrow(()->new Exception("USER NOT FOUND"));
//	        	appointment remindapp=new appointment();
//	        	remindapp.setAppuser(reminduser);
//	        	remindapp.setSp(appointment.getSp());
//	        	remindapp.setStartTime(appointment.getStartTime());
//	        	remindapp.setEndTime(appointment.getEndTime());
//	        	remindapp.setStatus(appointment.getStatus());
//	        	remindapp.setRemind_status("REMINDED");
//	        	apprepo.save(remindapp);
	            
	        	}
	        	}
	        }

	    private void sendReminderEmail(appointment appointment) {
	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setTo(appointment.getAppuser().getEmail());
	        message.setSubject("Appointment Reminder");
	        message.setText("Your appointment with " + appointment.getSp().getServicename() +
	                         " is scheduled at " + appointment.getStartTime() +
	                         ". Please be on time.");

	        javaMailSender.send(message);
	    }
}
