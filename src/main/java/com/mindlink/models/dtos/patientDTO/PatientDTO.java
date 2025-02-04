package com.mindlink.models.dtos.patientDTO;

import java.time.LocalDate;

import com.mindlink.utils.enums.Gender;

public record PatientDTO(
                String firstName,
                String lastName,
                String email,
                LocalDate dateOfBirth,
                Gender gender) {

}
