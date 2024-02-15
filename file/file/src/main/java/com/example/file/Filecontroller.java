package com.example.file;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class Filecontroller {
	@Autowired
	private Fileservice ss;
	
	@PostMapping("/upload")
	public ResponseEntity<String> upload(@RequestParam("file")MultipartFile file) throws IOException{
		String filename=ss.store(file);
		return ResponseEntity.ok().body("File "+filename+" uploaded succesfully");
	}
	@GetMapping("/download/{id}")
	public ResponseEntity<byte[]> download(@PathVariable Long id) throws Exception{
		
		Fileentity fileData = ss.getid(id);
        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename=\"" + fileData.getName() + "\"")
                .body(fileData.getFile());
		
	}

}
