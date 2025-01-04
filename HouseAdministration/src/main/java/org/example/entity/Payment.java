package org.example.entity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.time.LocalDate;

//@Entity
public class Payment extends BaseEntity {
    private double amount;
    private LocalDate paymentDate;
    @OneToOne(mappedBy = "company")
    private Company company;
}
