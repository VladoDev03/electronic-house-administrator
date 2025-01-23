package org.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import java.util.Set;

@Entity
public class Resident extends Person {
    private boolean usesElevator;

    @ManyToMany(mappedBy = "owners")
    private Set<Apartment> ownedApartments;

    @ManyToMany(mappedBy = "residents")
    private Set<Apartment> apartments;

    public Resident() {
        super();
    }

    public Resident(String firstName, String lastName, int age, boolean usesElevator, Set<Apartment> ownedApartments, Set<Apartment> apartments) {
        super(firstName, lastName, age);
        this.usesElevator = usesElevator;
        this.ownedApartments = ownedApartments;
        this.apartments = apartments;
    }

    public Resident(long id, String firstName, String lastName, int age, boolean usesElevator, Set<Apartment> ownedApartments, Set<Apartment> apartments) {
        super(id, firstName, lastName, age);
        this.usesElevator = usesElevator;
        this.ownedApartments = ownedApartments;
        this.apartments = apartments;
    }

    public boolean isUsesElevator() {
        return usesElevator;
    }

    public Set<Apartment> getOwnedApartments() {
        return ownedApartments;
    }

    public Set<Apartment> getApartments() {
        return apartments;
    }
}
