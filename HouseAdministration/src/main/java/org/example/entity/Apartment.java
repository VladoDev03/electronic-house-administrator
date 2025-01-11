package org.example.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Apartment extends BaseEntity {
    private int floor;

    @Column(name = "apartment_number")
    private int apartmentNumber;

    private int area;
    private boolean hasPet;

    @ManyToOne
    private Building building;

    @OneToMany(mappedBy = "apartment")
    private Set<Resident> residents;

    @ManyToMany
    @JoinTable(
            name = "apartment_owners",
            joinColumns = @JoinColumn(name = "apartment_id"),
            inverseJoinColumns = @JoinColumn(name = "resident_id")
    )
    private Set<Resident> owners;

    public Apartment() {
    }

    public Apartment(int floor, int apartmentNumber, int area, boolean hasPet, Building building, Set<Resident> residents, Set<Resident> owners) {
        this.floor = floor;
        this.apartmentNumber = apartmentNumber;
        this.area = area;
        this.hasPet = hasPet;
        this.building = building;
        this.residents = residents;
        this.owners = owners;
    }

    public Apartment(long id, int floor, int apartmentNumber, int area, boolean hasPet, Building building, Set<Resident> residents, Set<Resident> owners) {
        super(id);
        this.floor = floor;
        this.apartmentNumber = apartmentNumber;
        this.area = area;
        this.hasPet = hasPet;
        this.building = building;
        this.residents = residents;
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

    public boolean getHasPet() {
        return hasPet;
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
}
