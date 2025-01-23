package org.example.dto.Company;

import org.example.dto.Employee.EmployeeBuildingCountDto;

import java.util.List;

public class CompanyWithEmployees {
    private final String companyName;
    private final List<EmployeeBuildingCountDto> employees;

    public CompanyWithEmployees(String companyName, List<EmployeeBuildingCountDto> employees) {
        this.companyName = companyName;
        this.employees = employees;
    }

    public String getCompanyName() {
        return companyName;
    }

    public List<EmployeeBuildingCountDto> getEmployees() {
        return employees;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Company Name: ").append(companyName).append("\n");
        employees.forEach(employee -> sb.append(employee).append("\n"));
        sb.append("\n");

        return sb.toString();
    }
}
