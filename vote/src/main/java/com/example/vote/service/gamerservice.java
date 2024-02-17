package com.example.vote.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vote.entity.gamers;
import com.example.vote.repo.gamersrepo;

@Service
public class gamerservice {
	@Autowired
	private gamersrepo grepo;
	
	public gamers addgamers(gamers game) {
		gamers gg=new gamers();
		gg.setGid(game.getGid());
		gg.setName(game.getName());
		gg.setVotes(0);
		gg.setResult("PROCESSING");
		return grepo.save(gg);
	}

}
