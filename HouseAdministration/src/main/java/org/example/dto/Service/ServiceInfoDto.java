package org.example.dto.Service;

import org.example.entity.Building;

public class ServiceInfoDto {
    private final double priceArea;
    private final double priceResident;
    private final double priceAnimal;
    private final double priceElevator;

    public ServiceInfoDto(double priceArea, double priceResident, double priceAnimal, double priceElevator) {
        this.priceArea = priceArea;
        this.priceResident = priceResident;
        this.priceAnimal = priceAnimal;
        this.priceElevator = priceElevator;
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
}
