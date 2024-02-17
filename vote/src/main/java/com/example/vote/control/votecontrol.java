package com.example.vote.control;

import java.io.ByteArrayInputStream;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.vote.entity.election;
import com.example.vote.entity.gamers;
import com.example.vote.entity.voters;
import com.example.vote.pdf.pdfconfig;
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
	@Autowired
	private pdfconfig pdf;
	
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
	@GetMapping("/result")
	public List<gamers> results(){
		return grepo.findAll();
	}
	@GetMapping("/result/report")
	public ResponseEntity<InputStreamResource> getpdf(){
		List<gamers> all=grepo.findAll();
		ByteArrayInputStream bytes=pdf.generatePdfReport(all);

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=result-report.pdf");

        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(new InputStreamResource(bytes));
 
	}
	
	@GetMapping("/result/votersreport")
	public ResponseEntity<InputStreamResource> getvoterspdf(){
		List<election> all=erepo.findAll();
		ByteArrayInputStream bytes=pdf.generatevotersPdfReport(all);

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Voters-report.pdf");

        return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF).body(new InputStreamResource(bytes));
 
	}

}
