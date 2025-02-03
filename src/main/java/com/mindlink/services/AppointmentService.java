/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.mindlink.services;

import java.util.List;

import com.mindlink.models.dtos.appointmentdtos.AppointmentDTO;
import com.mindlink.models.dtos.appointmentdtos.AppointmentRegistrationDTO;
import com.mindlink.models.dtos.appointmentdtos.AppointmentUpdateDTO;

/**
 *
 * @author madtore
 */
public interface AppointmentService {

    List<AppointmentDTO> getAppointmentByPatientEmail(String email);

    List<AppointmentDTO> getAppointmentByDoctorEmail(String email);

    void deleteAppointment(Long id);

    AppointmentRegistrationDTO createAppointment(AppointmentRegistrationDTO appointmentDTO);

    AppointmentDTO updateAppointment(AppointmentUpdateDTO appointmentDTO);

}
