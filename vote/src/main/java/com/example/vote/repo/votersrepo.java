package com.example.vote.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.vote.entity.voters;

public interface votersrepo extends JpaRepository<voters,Long>{

}
