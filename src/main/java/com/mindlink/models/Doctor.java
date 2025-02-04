package com.mindlink.models;

import com.mindlink.utils.enums.Gender;
import com.mindlink.utils.enums.UserRole;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "doctors")
@Getter
@Setter
public class Doctor extends User {

    private String specialization;
    private String licenseNumber;
    private Double priceHour;

    public Doctor() {
    }

    public Doctor(String firstName, String lastName, String email, String password, LocalDate dateOfBirth,
            Gender gender, String specialization, String licenseNumber, Double priceHour) {
        super(firstName, lastName, email, password, UserRole.DOCTOR, dateOfBirth, gender);
        this.specialization = specialization;
        this.licenseNumber = licenseNumber;
        this.priceHour = priceHour;
    }
}
