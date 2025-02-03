package com.mindlink.models.dtos.appointmentdtos;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record AppointmentUpdateDTO(
                @NotNull Long id,
                @Min(value = 0, message = "Rating must be between 0 and 5") @Max(value = 5, message = "Rating must be between 0 and 5") Integer rating,
                String feedback,
                LocalDateTime appointmentDate) {

}
