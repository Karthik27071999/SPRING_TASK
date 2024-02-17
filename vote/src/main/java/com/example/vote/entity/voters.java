package com.example.vote.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

@Entity
public class voters {
	@Id
	private long id;
	@NotNull
	@Email
	@Column(unique=true)
	private String email;
	public long getId() {
		return id;
	}
	public String getEmail() {
		return email;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	private voters(long id, @NotNull @Email String email) {
		super();
		this.id = id;
		this.email = email;
	}
	private voters() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
