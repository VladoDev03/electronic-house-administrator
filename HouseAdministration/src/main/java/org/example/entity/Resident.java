package org.example.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.Set;

@Entity
public class Resident extends Person {
    private boolean usesElevator;

    @ManyToMany(mappedBy = "owners")
    private Set<Apartment> ownedApartments;

    @ManyToOne
    private Apartment apartment;

    public Resident() {
        super();
    }

    public Resident(String firstName, String lastName, int age, boolean usesElevator, Set<Apartment> ownedApartments, Apartment apartment) {
        super(firstName, lastName, age);
        this.usesElevator = usesElevator;
        this.ownedApartments = ownedApartments;
        this.apartment = apartment;
    }

    public Resident(long id, String firstName, String lastName, int age, boolean usesElevator, Set<Apartment> ownedApartments, Apartment apartment) {
        super(id, firstName, lastName, age);
        this.usesElevator = usesElevator;
        this.ownedApartments = ownedApartments;
        this.apartment = apartment;
    }

    public boolean isUsesElevator() {
        return usesElevator;
    }

    public Set<Apartment> getOwnedApartments() {
        return ownedApartments;
    }

    public Apartment getApartment() {
        return apartment;
    }
}
