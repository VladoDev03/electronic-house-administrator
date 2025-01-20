package org.example.dto.Payment;

import java.time.LocalDate;

public class NewPaymentDto {
    private final long apartmentId;
    private final double amount;
    private final LocalDate paymentDate;
    private final long apartmentNumber;

    public NewPaymentDto(long apartmentId, double amount, long apartmentNumber) {
        this.apartmentId = apartmentId;
        this.amount = amount;
        this.paymentDate = LocalDate.now();
        this.apartmentNumber = apartmentNumber;
    }

    public long getApartmentId() {
        return apartmentId;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
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
