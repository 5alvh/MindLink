package com.mindlink.models.dtos.paymentdtos;

import java.time.LocalDate;

public record PaymentDTO(
        Double totalAmount,
        LocalDate createdAt) {
}
