package com.example.file;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class Fileservice {
	@Autowired
	private Filerepo repo;
	
	public String store(MultipartFile file) throws IOException {
		Fileentity en=new Fileentity(file.getOriginalFilename(),file.getBytes());
		repo.save(en);
		return en.getName();
	}
	
	public Fileentity getid(Long id) throws Exception {
		
		return repo.findById(id).orElseThrow(()->new Exception("NOT FOUND"));
		
	}

}
