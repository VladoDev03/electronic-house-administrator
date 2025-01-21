package org.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class Payment extends BaseEntity {
    private double amount;

    @Column(name = "payment_date")
    private LocalDate paymentDate;

    @ManyToOne
    private Apartment apartment;

    public Payment() {
    }

    public Payment(double amount, LocalDate paymentDate, Apartment apartment) {
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.apartment = apartment;
    }

    public Payment(long id, double amount, LocalDate paymentDate, Apartment apartment) {
        super(id);
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.apartment = apartment;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public Apartment getApartment() {
        return apartment;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Amount: ").append(getAmount()).append("\n");
        sb.append("Payment Date: ").append(getPaymentDate()).append("\n");
        sb.append("Apartment Number: ").append(getApartment().getApartmentNumber()).append("\n");
        sb.append("Apartment Floor: ").append(getApartment().getFloor()).append("\n");
        sb.append("Building Address: ").append(getApartment().getBuilding().getAddress()).append("\n");
        sb.append("Employee Name: ").append(getApartment().getBuilding().getResponsibleEmployee().getFirstName());
        sb.append(getApartment().getBuilding().getResponsibleEmployee().getLastName()).append("\n");
        sb.append("Company Name: ").append(getApartment().getBuilding().getResponsibleEmployee().getCompany().getName()).append("\n");

        return sb.toString();
    }
}
