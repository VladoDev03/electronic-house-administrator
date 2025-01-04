package org.example.entity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

//@Entity
public class BuildingPayment extends Payment {
    @OneToOne
    private Building building;
}
