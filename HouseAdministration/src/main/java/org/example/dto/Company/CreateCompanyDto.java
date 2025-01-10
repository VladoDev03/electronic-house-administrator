package org.example.dto;

import org.example.entity.Employee;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class CreateCompanyDto {
    private final String name;
    private final LocalDate foundationDate;
    private Set<Employee> employees;

    public CreateCompanyDto(String name, Set<Employee> employees) {
        this(name);
        this.employees = employees;
    }

    public CreateCompanyDto(String name) {
        this.name = name;
        this.foundationDate = LocalDate.now();
        this.employees = new HashSet<>();
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
