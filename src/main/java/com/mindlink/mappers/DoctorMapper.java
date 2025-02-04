package com.mindlink.mappers;

import com.mindlink.models.Doctor;
import com.mindlink.models.dtos.doctorDTO.DoctorDTO;

public class DoctorMapper {

    public static DoctorDTO doctorToDTo(Doctor doctor) {
        return new DoctorDTO(doctor.getFirstName(), doctor.getLastName(),
                doctor.getEmail(), doctor.getDateOfBirth(),
                doctor.getGender(), doctor.getSpecialization(), doctor.getLicenseNumber(),
                doctor.getPriceHour());
    }

}
