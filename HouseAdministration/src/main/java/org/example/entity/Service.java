package org.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Service extends BaseEntity {
    @Column(name = "price_area")
    private boolean priceArea;

    @Column(name = "price_resident")
    private boolean priceResident;

    @Column(name = "price_animal")
    private boolean priceAnimal;

    @Column(name = "price_elevator")
    private boolean priceElevator;

    @OneToOne
    private Building building;

    public Service() {
    }

    public Service(boolean priceArea, boolean priceResident, boolean priceAnimal, boolean priceElevator, Building building) {
        this.priceArea = priceArea;
        this.priceResident = priceResident;
        this.priceAnimal = priceAnimal;
        this.priceElevator = priceElevator;
        this.building = building;
    }

    public Service(long id, boolean priceArea, boolean priceResident, boolean priceAnimal, boolean priceElevator, Building building) {
        super(id);
        this.priceArea = priceArea;
        this.priceResident = priceResident;
        this.priceAnimal = priceAnimal;
        this.priceElevator = priceElevator;
        this.building = building;
    }

    public boolean isPriceArea() {
        return priceArea;
    }

    public boolean isPriceResident() {
        return priceResident;
    }

    public boolean isPriceAnimal() {
        return priceAnimal;
    }

    public boolean isPriceElevator() {
        return priceElevator;
    }

    public Building getBuilding() {
        return building;
    }
}
