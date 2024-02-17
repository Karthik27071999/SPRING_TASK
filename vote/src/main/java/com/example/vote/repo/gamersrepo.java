package com.example.vote.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.vote.entity.gamers;

public interface gamersrepo extends JpaRepository<gamers,Long> {
	@Query
	gamers findByname(String name);
	
	  @Query("SELECT c FROM gamers c WHERE c.votes = (SELECT MAX(c2.votes) FROM gamers c2)")
	    List<gamers> findwinner();


}
