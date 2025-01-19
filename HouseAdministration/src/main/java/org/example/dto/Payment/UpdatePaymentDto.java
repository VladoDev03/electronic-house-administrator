package org.example.dto.Payment;

import org.example.entity.Apartment;

import java.time.LocalDate;

public class UpdatePaymentDto {
    private final long id;
    private final double amount;
    private final LocalDate paymentDate;
    private final Apartment apartment;

    public UpdatePaymentDto(long id, double amount, LocalDate paymentDate, Apartment apartment) {
        this.id = id;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.apartment = apartment;
    }

    public long getId() {
        return id;
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
