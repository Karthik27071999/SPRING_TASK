package com.app.crud;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@Autowired
	private UserService service;
	
	@GetMapping("/get")
	public List<UserEntity> getall() {
		return service.getall();
	}
	
	@PostMapping("/post")
	public UserEntity postdata(@RequestBody UserEntity ue) {
		return service.post(ue);
	}
	
	@PutMapping("/update/{id}")
	public UserEntity updateone(@PathVariable Long id, @RequestBody UserEntity ue) {
		return service.update(id, ue);
	}
	
	
	
	@GetMapping("/get/{id}")
	public Optional<UserEntity> getid(@PathVariable Long id) {
		return service.getById(id);
	}

}
