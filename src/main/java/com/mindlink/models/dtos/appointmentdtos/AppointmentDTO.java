package com.mindlink.models.dtos.appointmentdtos;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.mindlink.utils.enums.SessionType;

public record AppointmentDTO(
        Long id,
        String patientEmail,
        String doctorEmail,
        String room,
        LocalDateTime appointmentDate,
        SessionType sessionType,
        Double totalCost,
        Integer rating,
        String feedback,
        LocalDate createdAt,
        LocalDate updatedAt,
        boolean isDeleted) {
}
