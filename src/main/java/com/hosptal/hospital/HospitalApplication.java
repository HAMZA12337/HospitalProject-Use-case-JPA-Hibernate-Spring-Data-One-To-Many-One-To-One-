package com.hosptal.hospital;

import com.hosptal.hospital.entities.*;
import com.hosptal.hospital.repositories.ConsultationRepository;
import com.hosptal.hospital.repositories.MedecinRepository;
import com.hosptal.hospital.repositories.PatientRepository;
import com.hosptal.hospital.repositories.RendezVousRepository;
import com.hosptal.hospital.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class, args);
    }

    // s executer au demarage+ return un objet spring
    // en plus on a plus besoin de declarer des variable @AUTOWIRD private patient repositoryPatient patient(exmple)
    @Bean
  CommandLineRunner start(IHospitalService hospitalService){
        return args -> {

            // dans ce cas la sa pas de sens je vais remplir des champs inutils
//            patientRepository.save(new Patient(null,"hamza",new Date(),false,null));
            // c est mieux de faire
            Stream.of("Mohammed","Hamid","Najat","Hayatm").forEach(name->{
                Patient patient = new Patient();
                patient.setNom(name);
                patient.setDateNaissance(new Date());
                patient.setMalade(false);
                hospitalService.savePatient(patient);

            });

            // L'ajout des medecis
            Stream.of("DR.Mohammed","DR.Hamid","DR.Najat","DR.Hayatm").forEach(name->{
                Medecin medecin = new Medecin();
                medecin.setNom(name);
                medecin.setSpecialite(Math.random()>0.5 ? "Cardio":"Dentiste");
                medecin.setEmail(name+"@gmail.com");
                hospitalService.saveMedecin(medecin);

            });

        // get Patients
            Patient patient=hospitalService.findPatientById(1L);
//            List<Patient> patients=patientRepository.findByNom("Hamid");


            // get Doctor
            Medecin medecin=hospitalService.findMedecinById(1L);

            // create an appointment

            RendezVous rendezVous= new RendezVous();
            rendezVous.setDateRDV(new Date());
            rendezVous.setStatus(StatusRDV.PENDING);
            rendezVous.setPatient(patient);
            rendezVous.setMedecin(medecin);
            hospitalService.saveRDV(rendezVous);

          // Create Consultation

          Consultation consultation = new Consultation();
          consultation.setDateConsultation(new Date());
          consultation.setRapportConsultation("Voila votre Rapport :hhhhhhhhhh");
          consultation.setRendezVous(rendezVous);
          hospitalService.saveConsultation(consultation);



        };
     }










}
