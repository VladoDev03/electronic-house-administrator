package org.example.entity;

import jakarta.validation.constraints.Positive;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Apartment extends BaseEntity {
    @Positive
    private int floor;

    @Column(name = "apartment_number")
    private int apartmentNumber;

    @Positive
    private int area;

    @ManyToOne
    private Building building;

    @OneToMany(mappedBy = "apartment")
    private Set<Pet> pets;

    @OneToMany(mappedBy = "apartment")
    private Set<Payment> payments;

    @ManyToMany
    @JoinTable(
            name = "apartment_owner",
            joinColumns = @JoinColumn(name = "apartment_id"),
            inverseJoinColumns = @JoinColumn(name = "resident_id")
    )
    private Set<Resident> owners;

    @ManyToMany
    @JoinTable(
            name = "apartment_resident",
            joinColumns = @JoinColumn(name = "apartment_id"),
            inverseJoinColumns = @JoinColumn(name = "resident_id")
    )
    private Set<Resident> residents;

    public Apartment() {
    }

    public Apartment(int floor, int apartmentNumber, int area, Building building, Set<Pet> pets, Set<Resident> residents, Set<Payment> payments, Set<Resident> owners) {
        this.floor = floor;
        this.apartmentNumber = apartmentNumber;
        this.area = area;
        this.building = building;
        this.pets = pets;
        this.residents = residents;
        this.payments = payments;
        this.owners = owners;
    }

    public Apartment(long id, int floor, int apartmentNumber, int area, Building building, Set<Pet> pets, Set<Resident> residents, Set<Payment> payments, Set<Resident> owners) {
        super(id);
        this.floor = floor;
        this.apartmentNumber = apartmentNumber;
        this.area = area;
        this.building = building;
        this.pets = pets;
        this.residents = residents;
        this.payments = payments;
        this.owners = owners;
    }

    public int getFloor() {
        return floor;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public int getArea() {
        return area;
    }

    public Building getBuilding() {
        return building;
    }

    public Set<Resident> getResidents() {
        return residents;
    }

    public Set<Resident> getOwners() {
        return owners;
    }

    public Set<Payment> getPayments() {
        return payments;
    }

    public Set<Pet> getPets() {
        return pets;
    }
}
