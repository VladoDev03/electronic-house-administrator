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

    public Company() {
    }

    public Company(String name, LocalDate foundationDate, Set<Employee> employees) {
        this.name = name;
        this.foundationDate = foundationDate;
        this.employees = employees;
    }

    public Company(long id, String name, LocalDate foundationDate, Set<Employee> employees) {
        super(id);
        this.name = name;
        this.foundationDate = foundationDate;
        this.employees = employees;
    }

    public String getName() {
        return name;
    }

    public LocalDate getFoundationDate() {
        return foundationDate;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }
}
