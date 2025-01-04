package org.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class Company extends BaseEntity {
    private String name;
    @Column(name = "foundation_date")
    private LocalDate foundationDate;
    @OneToMany(mappedBy = "company")
    private Set<Employee> employees;
}
