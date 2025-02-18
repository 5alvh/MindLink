package com.mindlink.models.dtos.userdtos;

import com.mindlink.utils.enums.Gender;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.time.LocalDate;

public record DoctorRegistrationRequest(
                @NotBlank @Getter String firstName,

                @NotBlank @Getter String lastName,

                @Email @NotBlank @Getter String email,

                @Size(min = 8) @NotBlank @Getter String password,

                @Past @Getter LocalDate dateOfBirth,

                @Getter Gender gender,

                @NotBlank @Getter String specialization,

                @NotBlank @Getter String licenseNumber,

                @Getter @Positive @NotNull Double priceHour) {
}