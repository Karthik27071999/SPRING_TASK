package com.example.appointment.repo;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.appointment.entity.appointment;

public interface appointmentrepo extends JpaRepository<appointment,Long>{
	
    @Query("SELECT COUNT(a) > 0 FROM appointment a WHERE a.sp.servicename = :serviceName " +
            "AND ((:startTime BETWEEN a.startTime AND a.endTime) OR (:endTime BETWEEN a.startTime AND a.endTime))")
     boolean existsOverlappingAppointments(
             @Param("serviceName") String serviceName,
             @Param("startTime") LocalDateTime startTime,
             @Param("endTime") LocalDateTime endTime);
    
    @Query("SELECT a FROM appointment a WHERE a.startTime BETWEEN :startTime AND :endTime")
    List<appointment> findUpcomingAppointments(
            @Param("startTime") LocalDateTime startTime,
            @Param("endTime") LocalDateTime endTime);

}
