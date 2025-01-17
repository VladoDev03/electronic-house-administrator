package org.example.dto.Company;

import org.example.entity.Employee;

import java.time.LocalDate;
import java.util.Set;

public class UpdateCompanyDto {
    private final long id;
    private final String name;
    private final LocalDate foundationDate;
    private final Set<Employee> employees;

    public UpdateCompanyDto(long id, String name, LocalDate foundationDate, Set<Employee> employees) {
        this.id = id;
        this.name = name;
        this.foundationDate = foundationDate;
        this.employees = employees;
    }

    public long getId() {
        return id;
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
