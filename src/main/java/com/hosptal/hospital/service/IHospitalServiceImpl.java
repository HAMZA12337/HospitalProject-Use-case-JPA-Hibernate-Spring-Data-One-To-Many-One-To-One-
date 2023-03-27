package com.hosptal.hospital.service;

import com.hosptal.hospital.entities.Consultation;
import com.hosptal.hospital.entities.Medecin;
import com.hosptal.hospital.entities.Patient;
import com.hosptal.hospital.entities.RendezVous;
import com.hosptal.hospital.repositories.ConsultationRepository;
import com.hosptal.hospital.repositories.MedecinRepository;
import com.hosptal.hospital.repositories.PatientRepository;
import com.hosptal.hospital.repositories.RendezVousRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@Transactional
public class IHospitalServiceImpl implements IHospitalService {

    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;
    private RendezVousRepository rendezVousRepository;
    private ConsultationRepository consultationRepository;


    // Maintenant pour faire l injection des dependences 2 methdoe soit (autowird soit constructor)


    public IHospitalServiceImpl(PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.consultationRepository = consultationRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous saveRDV(RendezVous rendezVous) {
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
//   consultation.setId(UUID.randomUUID().toString());
        return consultationRepository.save(consultation);
    }

    @Override
    public Patient findPatientById(Long id) {

    return patientRepository.findById(id).orElse(null);}

    @Override
    public Medecin findMedecinById(Long id) {
        return medecinRepository.findById(id).orElse(null);
    }
}
