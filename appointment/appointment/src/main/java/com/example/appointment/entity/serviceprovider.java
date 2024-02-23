package com.example.appointment.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Service_provider")
public class serviceprovider {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name="Servicer")
	private String servicename;
	private String context;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	@ManyToOne
	private appusers appuser;
	public long getId() {
		return id;
	}
	public String getServicename() {
		return servicename;
	}
	public String getContext() {
		return context;
	}
	public appusers getAppuser() {
		return appuser;
	}
	public LocalDateTime getStartTime() {
		return startTime;
	}
	public LocalDateTime getEndTime() {
		return endTime;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setServicename(String servicename) {
		this.servicename = servicename;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public void setAppuser(appusers appuser) {
		this.appuser = appuser;
	}
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
	public serviceprovider(long id, String servicename, String context, appusers appuser, LocalDateTime startTime,
			LocalDateTime endTime) {
		super();
		this.id = id;
		this.servicename = servicename;
		this.context = context;
		this.appuser = appuser;
		this.startTime = startTime;
		this.endTime = endTime;
	}
	public serviceprovider() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
