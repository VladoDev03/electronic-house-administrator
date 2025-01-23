package org.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Positive;

@Entity
public class Service extends BaseEntity {
    @Positive
    @Column(name = "price_area")
    private double priceArea;

    @Positive
    @Column(name = "price_resident")
    private double priceResident;

    @Positive
    @Column(name = "price_animal")
    private double priceAnimal;

    @Positive
    @Column(name = "price_animal_common_area")
    private double priceAnimalCommonArea;

    @Positive
    @Column(name = "price_elevator")
    private double priceElevator;

    @OneToOne
    private Building building;

    public Service() {
    }

    public Service(double priceArea, double priceResident, double priceAnimal, double priceAnimalCommonArea, double priceElevator, Building building) {
        this.priceArea = priceArea;
        this.priceResident = priceResident;
        this.priceAnimal = priceAnimal;
        this.priceAnimalCommonArea = priceAnimalCommonArea;
        this.priceElevator = priceElevator;
        this.building = building;
    }

    public Service(long id, double priceArea, double priceResident, double priceAnimal, double priceAnimalCommonArea, double priceElevator, Building building) {
        super(id);
        this.priceArea = priceArea;
        this.priceResident = priceResident;
        this.priceAnimal = priceAnimal;
        this.priceAnimalCommonArea = priceAnimalCommonArea;
        this.priceElevator = priceElevator;
        this.building = building;
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
