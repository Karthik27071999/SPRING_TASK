package com.example.appointment.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Appointments")
public class appointment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@ManyToOne
	@JoinColumn(name="User_id")
	private appusers appuser;
	@ManyToOne
	@JoinColumn(name="Servicer_id")
	private serviceprovider sp;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String status;
	public long getId() {
		return id;
	}
	public appusers getAppuser() {
		return appuser;
	}
	public serviceprovider getSp() {
		return sp;
	}
	public LocalDateTime getStartTime() {
		return startTime;
	}
	public LocalDateTime getEndTime() {
		return endTime;
	}
	public String getStatus() {
		return status;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setAppuser(appusers appuser) {
		this.appuser = appuser;
	}
	public void setSp(serviceprovider sp) {
		this.sp = sp;
	}
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	private appointment(long id, appusers appuser, serviceprovider sp, LocalDateTime startTime, LocalDateTime endTime,
			String status) {
		super();
		this.id = id;
		this.appuser = appuser;
		this.sp = sp;
		this.startTime = startTime;
		this.endTime = endTime;
		this.status = status;
	}
	public appointment() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    

}
