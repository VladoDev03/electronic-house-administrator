package org.example.dto.Building;

import org.example.entity.Apartment;
import org.example.entity.Employee;
import org.example.entity.Service;

import java.util.Set;

public class UpdateBuildingDto {
    private final long id;
    private final String address;
    private final int floors;
    private final double area;
    private final Set<Apartment> apartments;
    private final Employee responsibleEmployee;
    private final Service service;

    public UpdateBuildingDto(long id, String address, int floors, double area, Set<Apartment> apartments, Employee responsibleEmployee, Service service) {
        this.id = id;
        this.address = address;
        this.floors = floors;
        this.area = area;
        this.apartments = apartments;
        this.responsibleEmployee = responsibleEmployee;
        this.service = service;
    }

    public long getId() {
        return id;
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

    public Service getService() {
        return service;
    }
}
