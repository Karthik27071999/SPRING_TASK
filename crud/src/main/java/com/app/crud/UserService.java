package com.app.crud;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {
	@Autowired
	private Userrepository repo;
	
	public UserEntity post(UserEntity ue) {
		return repo.save(ue);
	}
	
	public Optional<UserEntity> getById(Long id) {
		return repo.findById(id);
	}
	
	public List<UserEntity> getall() {
		return repo.findAll();
	}
	
	
	public UserEntity update(Long id,UserEntity ue) {
		UserEntity user=repo.findById(id).orElseThrow(()->new EntityNotFoundException("ENTITY WITH GIVEN ID IS NOT FOUND"));
          user.setName(ue.getName());
          user.setEmail(ue.getEmail());
          
          return repo.save(user);
	}

}
