package org.example.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Apartment extends BaseEntity {
    private int floor;
    private int apartmentNumber;
    private int area;
    private boolean hasPet;

    @ManyToOne
    private Building building;

    @OneToMany(mappedBy = "apartment")
    private Set<Resident> residents;

    @ManyToMany
    @JoinTable(
            name = "apartment_owners",
            joinColumns = @JoinColumn(name = "apartment_id"),
            inverseJoinColumns = @JoinColumn(name = "resident_id")
    )
    private Set<Resident> owners;
}
