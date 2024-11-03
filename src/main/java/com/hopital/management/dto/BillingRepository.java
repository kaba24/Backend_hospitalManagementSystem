package com.hopital.management.dto;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hopital.management.model.Billing;

public interface BillingRepository extends JpaRepository<Billing, Long> {
    
}
