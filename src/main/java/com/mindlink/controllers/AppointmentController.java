
package com.mindlink.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mindlink.models.dtos.appointmentdtos.AppointmentDTO;
import com.mindlink.models.dtos.appointmentdtos.AppointmentRegistrationDTO;
import com.mindlink.models.dtos.appointmentdtos.AppointmentUpdateDTO;
import com.mindlink.services.AppointmentService;

import jakarta.validation.Valid;

/**
 *
 * @author madtore
 */
@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    private AppointmentService appointmentService;

    @Autowired
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping("/patient")
    public ResponseEntity<List<AppointmentDTO>> getAppointmentByPatientEmail(@Valid @RequestParam String patientEmail) {
        try {
            return ResponseEntity.ok(appointmentService.getAppointmentByPatientEmail(patientEmail));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/doctor")
    public ResponseEntity<List<AppointmentDTO>> getAppointmentByDoctorEmail(@Valid @RequestParam String doctorEmail) {
        try {
            return ResponseEntity.ok(appointmentService.getAppointmentByDoctorEmail(doctorEmail));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> createAppointment(
            @RequestBody AppointmentRegistrationDTO appointmentDTO) {
        try {
            return ResponseEntity.ok(appointmentService.createAppointment(appointmentDTO));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateAppointment(@Valid @RequestBody AppointmentUpdateDTO appointmentDTO) {
        try {
            return ResponseEntity.ok(appointmentService.updateAppointment(appointmentDTO));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteAppointment(@Valid @RequestParam Long id) {
        try {
            appointmentService.deleteAppointment(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
