package com.mindlink.services;

import java.util.Optional;

import com.mindlink.models.Doctor;
import com.mindlink.models.dtos.doctorDTO.DoctorDTO;
import org.springframework.data.domain.Page;

public interface DoctorService {
    Optional<Doctor> findByUserEmail(String email);

    DoctorDTO getDoctorByEmail(String email);

    Page<DoctorDTO> getDoctors(int pageNo, int pageSize);

}
