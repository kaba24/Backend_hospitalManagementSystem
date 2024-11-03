package com.hopital.management.dto;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hopital.management.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long>{
    
    
}
