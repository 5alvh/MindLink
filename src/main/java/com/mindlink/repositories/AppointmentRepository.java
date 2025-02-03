/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.mindlink.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mindlink.models.Appointment;

/**
 *
 * @author madtore
 */
@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    @Query("SELECT a FROM Appointment a WHERE a.patient.email = ?1")
    Optional<List<Appointment>> getAppointmentByPatient(String patientEmail);

    @Query("SELECT a FROM Appointment a WHERE a.doctor.email = ?1")
    Optional<List<Appointment>> getAppointmentByDoctor(String doctorEmail);

}
