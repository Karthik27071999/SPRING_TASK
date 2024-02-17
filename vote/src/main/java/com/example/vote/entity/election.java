package com.example.vote.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class election {
	@Id
	private long id;
	private String email;
	private String name;
	public long getId() {
		return id;
	}
	public String getEmail() {
		return email;
	}
	public String getName() {
		return name;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setName(String name) {
		this.name = name;
	}
	private election(long id, String email, String name) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
	}
	public election() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
