package org.example.dto.Service;

public class ServiceInfoDto {
    private final double priceArea;
    private final double priceResident;
    private final double priceAnimal;
    private final double priceAnimalCommonArea;
    private final double priceElevator;

    public ServiceInfoDto(double priceArea, double priceResident, double priceAnimal, double priceAnimalCommonArea, double priceElevator) {
        this.priceArea = priceArea;
        this.priceResident = priceResident;
        this.priceAnimal = priceAnimal;
        this.priceElevator = priceElevator;
        this.priceAnimalCommonArea = priceAnimalCommonArea;
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

    public double getPriceAnimalCommonArea() {
        return priceAnimalCommonArea;
    }
}
