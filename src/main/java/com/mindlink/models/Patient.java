package com.mindlink.models;

import com.mindlink.utils.enums.Gender;
import com.mindlink.utils.enums.UserRole;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "patients")
@Getter
@Setter
public class Patient extends User {

    public Patient() {
    }

    public Patient(String firstName, String lastName, String email, String password, LocalDate dateOfBirth,
            Gender gender) {
        super(firstName, lastName, email, password, UserRole.PATIENT, dateOfBirth, gender);
    }
}
