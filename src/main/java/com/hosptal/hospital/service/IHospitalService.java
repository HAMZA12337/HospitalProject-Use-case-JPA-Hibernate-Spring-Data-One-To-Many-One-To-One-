package com.hosptal.hospital.service;

import com.hosptal.hospital.entities.Consultation;
import com.hosptal.hospital.entities.Medecin;
import com.hosptal.hospital.entities.Patient;
import com.hosptal.hospital.entities.RendezVous;



// alt+entrer= creer l implementation
public interface IHospitalService {

   Patient savePatient(Patient patient);
    Medecin saveMedecin(Medecin medecin);
    RendezVous saveRDV(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);
    Patient findPatientById(Long id);
    Medecin findMedecinById(Long id);



}
