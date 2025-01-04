package org.example.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.Set;

@Entity
public class Resident extends Person {
    private boolean usesElevator;
    private boolean isOwner;
    @ManyToMany(mappedBy = "owners")
    private Set<Apartment> ownedApartments;
    @ManyToOne
    private Apartment apartment;
}
