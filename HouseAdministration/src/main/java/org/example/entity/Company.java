package org.example.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import org.example.validator.InvalidNames;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class Company extends BaseEntity {
    @NotBlank(message = "Company name cannot be blank!")
    @Size(max = 20, message = "Company name has to be with up to 20 characters!")
    @InvalidNames(message = "Company and Firm are not valid names!")
    @Column(name = "name", nullable = false)
    private String name;

    @PastOrPresent(message = "Foundation date cannot be in the future!")
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
