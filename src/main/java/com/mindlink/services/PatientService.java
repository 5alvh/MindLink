/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.mindlink.services;

import java.util.Optional;

import com.mindlink.models.Patient;
import com.mindlink.models.dtos.patientDTO.PatientDTO;

/**
 *
 * @author madtore
 */
public interface PatientService {

    Optional<Patient> findByUserEmail(String email);

    PatientDTO getPatientByEmail(String email);

}
