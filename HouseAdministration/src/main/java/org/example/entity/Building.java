package org.example.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Building extends BaseEntity {
    private String address;
    private int floors;
    private double area;
    @OneToMany(mappedBy = "building")
    private Set<Apartment> apartments;
    @ManyToOne
    private Employee responsibleEmployee;
}
