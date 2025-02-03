package com.mindlink.models.dtos.appointmentdtos;

import java.time.LocalDateTime;

import com.mindlink.utils.enums.SessionType;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

public record AppointmentRegistrationDTO(
                @NotNull(message = "Doctor email cannot be null") @Email(message = "Invalid doctor email format") String doctorEmail,

                @NotNull(message = "Patient email cannot be null") @Email(message = "Invalid patient email format") String patientEmail,

                @NotNull(message = "Appointment date cannot be null") @Future(message = "Appointment date must be in the future") LocalDateTime appointmentDate,

                @NotNull(message = "Session type cannot be null") SessionType sessionType) {

}
