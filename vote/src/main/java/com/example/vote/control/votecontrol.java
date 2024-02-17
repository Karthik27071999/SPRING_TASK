package com.example.vote.control;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.vote.entity.election;
import com.example.vote.entity.gamers;
import com.example.vote.entity.voters;
import com.example.vote.repo.electionrepo;
import com.example.vote.repo.gamersrepo;
import com.example.vote.req.request;
import com.example.vote.service.gamerservice;
import com.example.vote.service.voterservice;

@RestController
public class votecontrol {
	@Autowired
	private voterservice vs;
	@Autowired
	private gamerservice gs;
	@Autowired
	private electionrepo erepo;
	@Autowired
	private gamersrepo grepo;
	
	@PostMapping("/voterregister")
	public voters addone(@RequestBody voters votes) {
	  return vs.addvoters(votes);
	
	}
	
	@PostMapping("/gamerregister")
	public gamers addgamers(@RequestBody gamers game) {
		return gs.addgamers(game);
	}
	@PostMapping("/voting/{id}")
	public String voting(@PathVariable Long id,@RequestBody request req) throws Exception {
		voters vv=vs.getid(id).orElseThrow(()->new Exception("INVALID"));
		if(erepo.existsByemail(vv.getEmail())) {
			return "YOUR VOTING CHANCE IS COMPLETED";
		}
		else {
			//updating votes for candidate
			gamers gg=grepo.findByname(req.getName());
			gg.setVotes(gg.getVotes()+1);
			//finding the winner candidate with maximum votes
			 List<gamers> winners = grepo.findwinner();
		        int maxvotes = winners.isEmpty() ? 0 : winners.get(0).getVotes();

		   
		        List<gamers> gamers = grepo.findAll();
		        for (gamers games : gamers) {
		           
		             if (games.getVotes() == maxvotes) {
		                games.setResult("Winner");
		            } else {
		                games.setResult("Loser");
		            }
		        }
		        grepo.saveAll(gamers);
			
			election votes=new election();
			votes.setEmail(vv.getEmail());
			votes.setId(vv.getId());
			votes.setName(req.getName());
			erepo.save(votes);
			
			

			return "YOUR VOTE ADDED SUCCESFULLY";
		}
		
		
	}
	@GetMapping("/results")
	public List<gamers> results(){
		return grepo.findAll();
	}

}
