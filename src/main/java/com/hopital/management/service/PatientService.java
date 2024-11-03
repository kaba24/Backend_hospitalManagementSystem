package com.hopital.management.service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import com.hopital.management.dto.PatientRepository;
import com.hopital.management.model.Patient;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public Patient findById(Long id){
        Optional<Patient> optionPatient = patientRepository.findById(id);
        return optionPatient.orElseThrow(() -> new ResourceAccessException("Patient not available"));
    }
}