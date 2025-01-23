package org.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Pet extends BaseEntity {
    private boolean usesCommonArea;

    @ManyToOne
    private Apartment apartment;

    public Pet() {
    }

    public Pet(boolean uses_common_area, Apartment apartment) {
        this.usesCommonArea = uses_common_area;
        this.apartment = apartment;
    }

    public Pet(long id, boolean uses_common_area, Apartment apartment) {
        super(id);
        this.usesCommonArea = uses_common_area;
        this.apartment = apartment;
    }

    public boolean getUsesCommonArea() {
        return usesCommonArea;
    }

    public Apartment getApartment() {
        return apartment;
    }
}
