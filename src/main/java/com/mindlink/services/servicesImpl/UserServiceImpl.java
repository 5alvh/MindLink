package com.mindlink.services.servicesImpl;

import com.mindlink.models.Doctor;
import com.mindlink.models.Patient;
import com.mindlink.models.dtos.userdtos.DoctorRegistrationRequest;
import com.mindlink.models.dtos.userdtos.PatientRegistrationRequest;
import com.mindlink.repositories.UserRepository;
import com.mindlink.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void createPatient(PatientRegistrationRequest request) {

        Patient patient = new Patient(
                request.getFirstName(),
                request.getLastName(),
                request.getEmail(),
                passwordEncoder.encode(request.getPassword()),
                request.getDateOfBirth(),
                request.getGender());

        userRepository.save(patient);
    }

    @Override
    public void createDoctor(DoctorRegistrationRequest request) {

        Doctor doctor = new Doctor(
                request.getFirstName(),
                request.getLastName(),
                request.getEmail(),
                passwordEncoder.encode(request.getPassword()),
                request.getDateOfBirth(),
                request.getGender(),
                request.getSpecialization(),
                request.getLicenseNumber(),
                request.getPriceHour());

        userRepository.save(doctor);
    }
}
