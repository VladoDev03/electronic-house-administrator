package org.example.dto;

import org.example.entity.Employee;

import java.time.LocalDate;
import java.util.Set;

public class CreateCompanyDto {
    private String name;
    private LocalDate foundationDate;
    private Set<Employee> employees;

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
