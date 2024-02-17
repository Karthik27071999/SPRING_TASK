package com.example.vote.req;

public class request {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private request(String name) {
		super();
		this.name = name;
	}

	private request() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
