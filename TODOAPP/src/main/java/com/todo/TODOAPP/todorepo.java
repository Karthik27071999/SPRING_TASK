package com.todo.TODOAPP;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface todorepo extends JpaRepository<todoent, Long> {

}
