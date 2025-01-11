package org.example.dto.Employee;

import org.example.entity.Building;
import org.example.entity.Company;

import java.util.Set;

public class CreateEmployeeDto {
    private final String firstName;
    private final String lastName;
    private final int age;
    private final Set<Building> assignedBuildings;
    private final Company company;

    public CreateEmployeeDto(String firstName, String lastName, int age, Set<Building> assignedBuildings, Company company) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.assignedBuildings = assignedBuildings;
        this.company = company;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public Set<Building> getAssignedBuildings() {
        return assignedBuildings;
    }

    public Company getCompany() {
        return company;
    }
}