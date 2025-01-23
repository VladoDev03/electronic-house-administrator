package org.example.dto.Apartment;

import org.example.entity.Building;
import org.example.entity.Payment;
import org.example.entity.Pet;
import org.example.entity.Resident;

import java.util.Set;

public class CreateApartmentDto {
    private final int floor;
    private final int apartmentNumber;
    private final int area;
    private final Building building;
    private final Set<Resident> residents;
    private final Set<Resident> owners;
    private final Set<Payment> payments;
    private final Set<Pet> pets;

    public CreateApartmentDto(int floor, int apartmentNumber, int area, Building building, Set<Pet> pets, Set<Resident> residents, Set<Resident> owners, Set<Payment> payments) {
        this.floor = floor;
        this.apartmentNumber = apartmentNumber;
        this.area = area;
        this.building = building;
        this.residents = residents;
        this.owners = owners;
        this.payments = payments;
        this.pets = pets;
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
