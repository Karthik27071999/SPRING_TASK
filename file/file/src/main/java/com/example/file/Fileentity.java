package com.example.file;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Fileentity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String name;
	@Lob
	private byte[] file;
	public long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public byte[] getFile() {
		return file;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setFile(byte[] file) {
		this.file = file;
	}
	public Fileentity( String name, byte[] file) {
		super();
	
		this.name = name;
		this.file = file;
	}
	public Fileentity() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
