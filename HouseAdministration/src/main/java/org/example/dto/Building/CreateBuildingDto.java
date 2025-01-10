package org.example.dto.Building;

import org.example.entity.Apartment;
import org.example.entity.Employee;

import java.util.HashSet;
import java.util.Set;

public class CreateBuildingDto {
    private final String address;
    private final int floors;
    private final double area;
    private Set<Apartment> apartments;
    private Employee responsibleEmployee;

    public CreateBuildingDto(String address, int floors, double area) {
        this.address = address;
        this.floors = floors;
        this.area = area;
        this.apartments = new HashSet<>();
    }

    public CreateBuildingDto(String address, int floors, double area, Set<Apartment> apartments, Employee responsibleEmployee) {
        this(address, floors, area);
        this.apartments = apartments;
        this.responsibleEmployee = responsibleEmployee;
    }

    public String getAddress() {
        return address;
    }

    public int getFloors() {
        return floors;
    }

    public double getArea() {
        return area;
    }

    public Set<Apartment> getApartments() {
        return apartments;
    }

    public Employee getResponsibleEmployee() {
        return responsibleEmployee;
    }
}
