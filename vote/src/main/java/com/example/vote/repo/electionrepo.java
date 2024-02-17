package com.example.vote.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.vote.entity.election;
import com.example.vote.entity.voters;

public interface electionrepo extends JpaRepository<election, Long> {
	@Query
	boolean existsByemail(String email);

}
