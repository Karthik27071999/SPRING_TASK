package com.example.bank;

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

import com.example.bank.pdf.PdfReportService;
import com.example.bank.request.Accountreq;
import com.example.bank.request.bankrequest;
import com.example.bank.transaction.Transaction;
import com.example.bank.transaction.TransactionService;

@RestController
public class bankcontrol {
	@Autowired
	private bankservice service;
	@Autowired
	private TransactionService ss;
	@Autowired
    private PdfReportService pdfReportService;
	
	
	@PostMapping("/adduser")
	public bankent in(@RequestBody bankrequest req) {
		return service.added(req);
		
	}
	@GetMapping("/users")
	public List<bankent> get() {
		return service.getall();
	}
	@PostMapping("/credit/{id}")
	public Transaction credit(@PathVariable long id,@RequestBody Transaction tt) throws Exception {
		return ss.credit(id, tt.getAmount());
	}
	@PostMapping("/debit/{id}")
	public Transaction debit(@PathVariable long id,@RequestBody Transaction tt) throws Exception {
		return ss.debit(id, tt.getAmount());
	}
	 @PostMapping("/report")
	    public ResponseEntity<InputStreamResource> generatePdfReport(@RequestBody Accountreq account) {
	        List<Transaction> data = ss.getbyaccount(account.getAccount());// Assume you have a method to fetch data from database
	        ByteArrayInputStream pdfReport =pdfReportService.generatePdfReport(data);

	        HttpHeaders headers = new HttpHeaders();
	        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=report.pdf");

	        return ResponseEntity
	                .ok()
	                .headers(headers)
	                .contentType(MediaType.APPLICATION_PDF)
	                .body(new InputStreamResource(pdfReport));
	 }
	 @PostMapping("/account")
	 public List<Transaction> getaccount(@RequestBody Accountreq account){
		 return ss.getbyaccount(account.getAccount());
	 }

}
