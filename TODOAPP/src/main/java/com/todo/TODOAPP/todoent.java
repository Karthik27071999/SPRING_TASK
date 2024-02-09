package com.todo.TODOAPP;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="TODOENT")
public class todoent {
	@Id
	@Column(name="ID")
	private long id;
	@Column(name="TITLE")
	private String title;
	@Column(name="STATUS")
	private String status;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	private todoent(long id, String title, String status) {
		super();
		this.id = id;
		this.title = title;
		this.status = status;
	}
	private todoent() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
