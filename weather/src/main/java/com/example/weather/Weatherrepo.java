package com.example.weather;

import org.springframework.data.jpa.repository.JpaRepository;

public interface Weatherrepo extends JpaRepository<Weatherent, Long>{

}
