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
}
