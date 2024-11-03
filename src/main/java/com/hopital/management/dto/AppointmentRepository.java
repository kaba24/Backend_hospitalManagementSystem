package com.hopital.management.dto;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hopital.management.model.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment , Long> {
    
    
}
