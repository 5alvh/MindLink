package com.mindlink.models.dtos.userdtos;

import com.mindlink.utils.enums.Gender;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.time.LocalDate;

public record PatientRegistrationRequest(
        @NotBlank
        String firstName,

        @NotBlank
        String lastName,

        @Email
        @NotBlank
        String email,

        @Size(min = 8)
        @NotBlank
        String password,

        @Past
        LocalDate dateOfBirth,

        Gender gender
) {}
