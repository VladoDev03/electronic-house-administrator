package org.example.dto.Company;

import org.example.dto.Employee.FullEmployeeWithBuildingsInfoDto;

import java.time.LocalDate;
import java.util.List;

public class FullCompanyInfoDto {
    private final String name;
    private final LocalDate foundationDate;
    private final List<FullEmployeeWithBuildingsInfoDto> employees;

    public FullCompanyInfoDto(String name, LocalDate foundationDate, List<FullEmployeeWithBuildingsInfoDto> employees) {
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

    public List<FullEmployeeWithBuildingsInfoDto> getEmployees() {
        return employees;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Name: ").append(name).append("\n");
        sb.append("Foundation Date: ").append(foundationDate).append("\n");
        employees.forEach(e -> sb.append(e.toString()).append("\n"));

        return sb.toString();
    }
}
