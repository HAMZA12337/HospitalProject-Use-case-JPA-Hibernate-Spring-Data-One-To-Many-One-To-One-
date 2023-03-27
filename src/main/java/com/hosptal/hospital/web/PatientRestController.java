package com.hosptal.hospital.web;


import com.hosptal.hospital.entities.Patient;
import com.hosptal.hospital.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientRestController {


    @Autowired
private PatientRepository patientRepository;


    @GetMapping("/patients")
public List<Patient> getPatients(){

return patientRepository.findAll();}






}
