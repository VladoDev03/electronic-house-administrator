package org.example.entity;

//import jakarta.validation.constraints.Positive;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Service extends BaseEntity {
//    @Positive
    @Column(name = "price_area")
    private double priceArea;

//    @Positive
    @Column(name = "price_resident")
    private double priceResident;

//    @Positive
    @Column(name = "price_animal")
    private double priceAnimal;

//    @Positive
    @Column(name = "price_elevator")
    private double priceElevator;

    @OneToOne
    private Building building;

    public Service() {
    }

    public Service(double priceArea, double priceResident, double priceAnimal, double priceElevator, Building building) {
        this.priceArea = priceArea;
        this.priceResident = priceResident;
        this.priceAnimal = priceAnimal;
        this.priceElevator = priceElevator;
        this.building = building;
    }

    public Service(long id, double priceArea, double priceResident, double priceAnimal, double priceElevator, Building building) {
        super(id);
        this.priceArea = priceArea;
        this.priceResident = priceResident;
        this.priceAnimal = priceAnimal;
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
}
