package org.example.dto.Service;

import org.example.entity.Building;

public class UpdateServiceDto {
    private final long id;
    private final double priceArea;
    private final double priceResident;
    private final double priceAnimal;
    private final double priceElevator;
    private final double priceAnimalCommonArea;
    private final Building building;

    public UpdateServiceDto(long id, double priceArea, double priceResident, double priceAnimal, double priceAnimalCommonArea, double priceElevator, Building building) {
        this.id = id;
        this.priceArea = priceArea;
        this.priceResident = priceResident;
        this.priceAnimal = priceAnimal;
        this.priceElevator = priceElevator;
        this.building = building;
        this.priceAnimalCommonArea = priceAnimalCommonArea;
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

    public double getPriceAnimalCommonArea() {
        return priceAnimalCommonArea;
    }
}
