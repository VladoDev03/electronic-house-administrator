package org.example.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Employee extends Person {
    @OneToMany(mappedBy = "responsibleEmployee")
    private Set<Building> assignedBuildings;
    @ManyToOne
    private Company company;
}
