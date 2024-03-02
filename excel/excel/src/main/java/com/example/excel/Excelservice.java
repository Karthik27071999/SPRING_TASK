package com.example.excel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Excelservice {
	@Autowired
	private Excelrepo repo;
	
	public String saveall(List<Excelentity> excel) {
		 repo.saveAll(excel);
		 return "DATAS ARE SAVED SUCCESSFULLY";
		
	}

}
