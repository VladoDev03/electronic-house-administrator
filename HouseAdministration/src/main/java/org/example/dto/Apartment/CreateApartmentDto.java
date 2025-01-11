package org.example.dto.Apartment;

import org.example.entity.Building;
import org.example.entity.Resident;

import java.util.Set;

public class CreateApartmentDto {
    private final int floor;
    private final int apartmentNumber;
    private final int area;
    private final boolean hasPet;
    private final Building building;
    private final Set<Resident> residents;
    private final Set<Resident> owners;

    public CreateApartmentDto(int floor, int apartmentNumber, int area, boolean hasPet, Building building, Set<Resident> residents, Set<Resident> owners) {
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