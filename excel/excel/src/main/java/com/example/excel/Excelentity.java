package com.example.excel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Excelentity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String name;
	private String email;
	private double phone_num;
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public double getPhone_num() {
		return phone_num;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPhone_num(double d) {
		this.phone_num = d;
	}
	public Excelentity(long id, String name, String email, double phone_num) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone_num = phone_num;
	}
	public Excelentity() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
