package com.example.bank;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface bankrepo extends JpaRepository<bankent, Long> {
	@Query
	boolean existsByemail(String email);
    @Query
	bankent findByEmail(String email);

}
