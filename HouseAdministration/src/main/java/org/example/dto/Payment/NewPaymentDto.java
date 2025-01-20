package org.example.dto.Payment;

import java.time.LocalDate;

public class NewPaymentDto {
    private final double amount;
    private final LocalDate paymentDate;
    private final long apartmentNumber;

    public NewPaymentDto(double amount, long apartmentId) {
        this.amount = amount;
        this.paymentDate = LocalDate.now();
        this.apartmentNumber = apartmentId;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public double getAmount() {
        return amount;
    }

    public long getApartmentNumber() {
        return apartmentNumber;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Amount: ").append(amount).append("\n");
        sb.append("Payment Date: ").append(paymentDate).append("\n");
        sb.append("Apartment Number: ").append(apartmentNumber).append("\n");

        return sb.toString();
    }
}
