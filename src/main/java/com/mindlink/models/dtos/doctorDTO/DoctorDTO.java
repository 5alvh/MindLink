package com.mindlink.models.dtos.doctorDTO;

import java.time.LocalDate;

import com.mindlink.utils.enums.Gender;

public record DoctorDTO(
        String firstName,
        String lastName,
        String email,
        LocalDate dateOfBirth,
        Gender gender,
        String specialization,
        String licenseNumber,
        Double priceHour) {
}
