package com.example.excel;


import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class Excelcontroller {
	@Autowired
	private Excelservice service;
	
	@PostMapping("/excel")
	public String uploadexcel(@RequestPart("file") MultipartFile file) throws IOException{
		List<Excelentity> exceldata=Excelparser.parseExcel(file.getInputStream());
		return service.saveall(exceldata);
	}

}
