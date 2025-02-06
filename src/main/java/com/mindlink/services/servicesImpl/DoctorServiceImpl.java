package com.mindlink.services.servicesImpl;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mindlink.mappers.DoctorMapper;
import com.mindlink.models.Doctor;
import com.mindlink.models.dtos.doctorDTO.DoctorDTO;
import com.mindlink.repositories.DoctorRepository;
import com.mindlink.services.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService {

    private DoctorRepository doctorRepository;

    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public Optional<Doctor> findByUserEmail(String email) {
        return doctorRepository.findByUserEmail(email);

    }

    @Override
    public DoctorDTO getDoctorByEmail(String email) {
        Optional<Doctor> doctor = doctorRepository.findByUserEmail(email);
        if (doctor.isPresent()) {
            return DoctorMapper.doctorToDTo(doctor.get());
        } else {
            throw new RuntimeException("Patient not found");
        }
    }

    @Override
    public Page<DoctorDTO> getDoctors(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return doctorRepository.findAll(pageable).map(DoctorMapper::doctorToDTo);
    }

}
