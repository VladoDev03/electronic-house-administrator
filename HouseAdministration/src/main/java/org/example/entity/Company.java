package org.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Company extends BaseEntity {
    private String name;
    @Column(name = "foundation_date")
    private LocalDate foundationDate;
}
