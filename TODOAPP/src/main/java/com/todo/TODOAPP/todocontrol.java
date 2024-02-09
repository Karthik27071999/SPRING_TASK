package com.todo.TODOAPP;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class todocontrol {
	@Autowired
	 private todoservice service;
	
	@PostMapping("/post")
	public todoent postone(@RequestBody todoent ent) {
		return service.post(ent);
	}
	
	@GetMapping("/get/{id}")
	public Optional<todoent> getbyone(@PathVariable Long id) {
		return service.getById(id);
		
	}
	@GetMapping("/get")
	public List<todoent> getall() {
		return service.getevery();
	}
	
	@PutMapping("/update/{id}")
	public todoent update(@PathVariable Long id, @RequestBody todoent ent) {
		return service.update(id, ent);
		
	}
	@DeleteMapping("/delete")
	public String remove(@PathVariable Long id) {
		service.delete(id);
		return "DATAS REMOVED SUCCESFULLY";
		
	}
	@GetMapping("/getpdf")
	 public ResponseEntity<byte[]> downloadReport() {
	        try {
	            // Generate the report
	            byte[] reportBytes =  service.generatereport();

	            // Set the response headers
	            HttpHeaders headers = new HttpHeaders();
	            headers.setContentType(MediaType.APPLICATION_PDF);
	            headers.setContentDispositionFormData("attachment", "report.pdf");

	            return ResponseEntity.ok().headers(headers).body(reportBytes);
	        } catch (Exception e) {
	            // Handle exceptions appropriately
	            e.printStackTrace();
	            return ResponseEntity.badRequest().body(null);
	        }
	    }
}