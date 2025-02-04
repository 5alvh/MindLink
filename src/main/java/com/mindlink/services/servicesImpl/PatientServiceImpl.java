/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mindlink.services.servicesImpl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mindlink.mappers.PatientMapper;
import com.mindlink.models.Patient;
import com.mindlink.models.dtos.patientDTO.PatientDTO;
import com.mindlink.repositories.PatientRepository;
import com.mindlink.services.PatientService;

/**
 *
 * @author madtore
 */
@Service
public class PatientServiceImpl implements PatientService {

    private PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public Optional<Patient> findByUserEmail(String email) {
        return patientRepository.findByUserEmail(email);

    }

    @Override
    public PatientDTO getPatientByEmail(String email) {
        Optional<Patient> patient = patientRepository.findByUserEmail(email);
        if (patient.isPresent()) {
            return PatientMapper.patientToDTo(patient.get());
        } else {
            throw new RuntimeException("Patient not found");
        }
    }

}