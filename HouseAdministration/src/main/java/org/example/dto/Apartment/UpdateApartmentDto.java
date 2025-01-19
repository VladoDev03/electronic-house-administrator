package org.example.dto.Apartment;

import org.example.entity.Building;
import org.example.entity.Payment;
import org.example.entity.Resident;

import java.util.Set;

public class UpdateApartmentDto {
    private final long id;
    private final int floor;
    private final int apartmentNumber;
    private final int area;
    private final boolean hasPet;
    private final Building building;
    private final Set<Resident> residents;
    private final Set<Resident> owners;
    private final Set<Payment> payments;

    public UpdateApartmentDto(long id, int floor, int apartmentNumber, int area, boolean hasPet, Building building, Set<Resident> residents, Set<Resident> owners, Set<Payment> payments) {
        this.id = id;
        this.floor = floor;
        this.apartmentNumber = apartmentNumber;
        this.area = area;
        this.hasPet = hasPet;
        this.building = building;
        this.residents = residents;
        this.owners = owners;
        this.payments = payments;
    }

    public long getId() {
        return id;
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

    public Set<Payment> getPayments() {
        return payments;
    }
}
