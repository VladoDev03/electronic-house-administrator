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

    public Employee() {

    }

    public Employee(Set<Building> assignedBuildings, Company company) {
        this.assignedBuildings = assignedBuildings;
        this.company = company;
    }

    public Employee(String firstName, String lastName, int age, Set<Building> assignedBuildings, Company company) {
        super(firstName, lastName, age);
        this.assignedBuildings = assignedBuildings;
        this.company = company;
    }

    public Employee(long id, String firstName, String lastName, int age, Set<Building> assignedBuildings, Company company) {
        super(id, firstName, lastName, age);
        this.assignedBuildings = assignedBuildings;
        this.company = company;
    }

    public Set<Building> getAssignedBuildings() {
        return assignedBuildings;
    }

    public Company getCompany() {
        return company;
    }
}
