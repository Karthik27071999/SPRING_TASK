package com.example.file;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface Filerepo extends JpaRepository<Fileentity, Long>{

}
