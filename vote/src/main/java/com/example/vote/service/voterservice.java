package com.example.vote.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vote.entity.voters;
import com.example.vote.repo.votersrepo;

@Service
public class voterservice {
	@Autowired
	private votersrepo repo;
	
	public voters addvoters(voters vote) {
		return repo.save(vote);
	}
	public Optional<voters> getid(Long id)
	{
		return repo.findById(id);
	}


}
