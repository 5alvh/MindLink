package com.mindlink.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.mindlink.models.dtos.doctorDTO.DoctorDTO;
import com.mindlink.models.dtos.patientDTO.PatientDTO;
import com.mindlink.services.DoctorService;
import com.mindlink.services.PatientService;

@RestController
@RequestMapping("/user")
public class UserController {

    private DoctorService doctorService;
    private PatientService patientService;

    public UserController(DoctorService doctorService, PatientService patientService) {
        this.doctorService = doctorService;
        this.patientService = patientService;
    }

    @GetMapping("/doctor")
    public ResponseEntity<DoctorDTO> getDoctorByEmail(@RequestParam String email) {
        try {
            return ResponseEntity.ok(doctorService.getDoctorByEmail(email));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/patient")
    public ResponseEntity<PatientDTO> getPatientByEmail(@RequestParam String email) {
        try {
            return ResponseEntity.ok(patientService.getPatientByEmail(email));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
