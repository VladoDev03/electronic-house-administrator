package org.example.dto.Payment;

import org.example.entity.Apartment;

import java.time.LocalDate;

public class CreatePaymentDto {
    private final double amount;
    private final LocalDate paymentDate;
    private Apartment apartment;

    public CreatePaymentDto(double amount, Apartment apartment) {
        this(amount);
        this.apartment = apartment;
    }

    public CreatePaymentDto(double amount) {
        this.amount = amount;
        this.paymentDate = LocalDate.now();
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public double getAmount() {
        return amount;
    }
}
