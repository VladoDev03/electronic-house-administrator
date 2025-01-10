package org.example.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Building extends BaseEntity {
    private String address;
    private int floors;
    private double area;
    @OneToMany(mappedBy = "building")
    private Set<Apartment> apartments;
    @ManyToOne
    private Employee responsibleEmployee;

    public Building() {
    }

    public Building(String address, int floors, double area, Set<Apartment> apartments, Employee responsibleEmployee) {
        this.address = address;
        this.floors = floors;
        this.area = area;
        this.apartments = apartments;
        this.responsibleEmployee = responsibleEmployee;
    }

    public Building(long id, String address, int floors, double area, Set<Apartment> apartments, Employee responsibleEmployee) {
        super(id);
        this.address = address;
        this.floors = floors;
        this.area = area;
        this.apartments = apartments;
        this.responsibleEmployee = responsibleEmployee;
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
}
