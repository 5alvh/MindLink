package com.mindlink.mappers;

import com.mindlink.models.Appointment;
import com.mindlink.models.dtos.appointmentdtos.AppointmentDTO;

public class AppointmentMapper {

    public static AppointmentDTO appointmentToDTO(Appointment appointment) {
        AppointmentDTO dto = new AppointmentDTO(
                appointment.getId(),
                appointment.getPatient().getEmail(),
                appointment.getDoctor().getEmail(),
                appointment.getRoom().getRoomUrl(),
                appointment.getAppointmentDate(),
                appointment.getSessionType(),
                appointment.getTotalCost(),
                appointment.getRating(),
                appointment.getFeedback(),
                appointment.getCreatedAt(),
                appointment.getUpdatedAt(),
                appointment.getDeletedAt() != null);
        return dto;
    }
}

