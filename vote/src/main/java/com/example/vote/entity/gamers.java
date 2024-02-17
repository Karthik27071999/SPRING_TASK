package com.example.vote.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class gamers {
	@Id
	private long gid;
	private String name;
	private int votes;
	private String result;
	public long getGid() {
		return gid;
	}
	public String getName() {
		return name;
	}
	public int getVotes() {
		return votes;
	}
	public String getResult() {
		return result;
	}
	public void setGid(long gid) {
		this.gid = gid;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setVotes(int votes) {
		this.votes = votes;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public gamers(long gid, String name, int votes, String result) {
		super();
		this.gid = gid;
		this.name = name;
		this.votes = votes;
		this.result = result;
	}
	public gamers() {
		super();
		// TODO Auto-generated constructor stub
	}
}