package org.example.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.Set;

@Entity
public class Building extends BaseEntity {
    @NotBlank(message = "Building address cannot be blank!")
    @Size(max = 20, message = "Building address has to be with up to 20 characters!")
    private String address;

    @Positive
    private int floors;

    @Positive
    private double area;

    @OneToMany(mappedBy = "building")
    private Set<Apartment> apartments;

    @ManyToOne
    @JoinColumn(name = "responsible_employee_id")
    private Employee responsibleEmployee;

    @OneToOne(mappedBy = "building")
    private Service service;

    public Building() {
    }

    public Building(String address, int floors, double area, Set<Apartment> apartments, Employee responsibleEmployee, Service service) {
        this.address = address;
        this.floors = floors;
        this.area = area;
        this.apartments = apartments;
        this.responsibleEmployee = responsibleEmployee;
        this.service = service;
    }

    public Building(long id, String address, int floors, double area, Set<Apartment> apartments, Employee responsibleEmployee, Service service) {
        super(id);
        this.address = address;
        this.floors = floors;
        this.area = area;
        this.apartments = apartments;
        this.responsibleEmployee = responsibleEmployee;
        this.service = service;
    }

    public Employee getResponsibleEmployee() {
        return responsibleEmployee;
    }

    public Set<Apartment> getApartments() {
        return apartments;
    }

    public double getArea() {
        return area;
    }

    public int getFloors() {
        return floors;
    }

    public String getAddress() {
        return address;
    }

    public Service getService() {
        return service;
    }
}
