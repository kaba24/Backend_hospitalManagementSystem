package com.hopital.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hopital.management.dto.PatientRepository;
import com.hopital.management.model.Patient;
import com.hopital.management.service.PatientService;



@RestController
@RequestMapping("/patients")
public class PatientController {
    
    @Autowired
    private PatientService patientService;

    private PatientRepository patientRepository;  
        public PatientController(PatientRepository patientRepository) {
            this.patientRepository = patientRepository;
        }

   
    @GetMapping
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @PostMapping
    public Patient createPatient(@RequestBody Patient patient) {
        return patientRepository.save(patient);
    }


    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable Long id) {
        return patientService.findById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Long id, @RequestBody Patient patientDetails) {
        return patientRepository.findById(id)
                .map(patient -> {
                    patient.setName(patientDetails.getName());
                    patient.setAge(patientDetails.getAge());
                    patient.setGender(patientDetails.getGender());
                    return ResponseEntity.ok(patientRepository.save(patient));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePatient(@PathVariable Long id) {
        return patientRepository.findById(id).map(patient -> {
                   patientRepository.delete(patient);
                    return ResponseEntity.noContent().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
