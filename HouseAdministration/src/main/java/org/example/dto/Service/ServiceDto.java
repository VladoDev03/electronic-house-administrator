package org.example.dto.Service;

import org.example.entity.Building;

public class ServiceDto {
    private final long id;
    private final double priceArea;
    private final double priceResident;
    private final double priceAnimal;
    private final double priceElevator;
    private final Building building;

    public ServiceDto(long id, double priceArea, double priceResident, double priceAnimal, double priceElevator, Building building) {
        this.id = id;
        this.priceArea = priceArea;
        this.priceResident = priceResident;
        this.priceAnimal = priceAnimal;
        this.priceElevator = priceElevator;
        this.building = building;
    }

    public long getId() {
        return id;
    }

    public double getPriceArea() {
        return priceArea;
    }

    public double getPriceResident() {
        return priceResident;
    }

    public double getPriceAnimal() {
        return priceAnimal;
    }

    public double getPriceElevator() {
        return priceElevator;
    }

    public Building getBuilding() {
        return building;
    }
}
