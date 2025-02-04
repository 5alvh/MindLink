package com.mindlink.mappers;

import com.mindlink.models.Patient;
import com.mindlink.models.dtos.patientDTO.PatientDTO;

public class PatientMapper {

    public static PatientDTO patientToDTo(Patient patient) {
        return new PatientDTO(patient.getFirstName(), patient.getLastName(),
                patient.getEmail(),
                patient.getDateOfBirth(), patient.getGender());
    }

}
