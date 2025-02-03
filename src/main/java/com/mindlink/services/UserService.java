package com.mindlink.services;

import com.mindlink.models.dtos.userdtos.DoctorRegistrationRequest;
import com.mindlink.models.dtos.userdtos.PatientRegistrationRequest;

public interface UserService {
    void createPatient(PatientRegistrationRequest patientRegistrationRequest);
    void createDoctor(DoctorRegistrationRequest doctorRegistrationRequest);
}