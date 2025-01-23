package org.example.dto.Pet;

import org.example.entity.Apartment;

public class UpdatePetDto {
    private final long id;
    private final boolean usesCommonArea;
    private final Apartment apartment;

    public UpdatePetDto(long id, boolean usesCommonArea, Apartment apartment) {
        this.id = id;
        this.usesCommonArea = usesCommonArea;
        this.apartment = apartment;
    }

    public long getId() {
        return id;
    }

    public boolean getUsesCommonArea() {
        return usesCommonArea;
    }

    public Apartment getApartment() {
        return apartment;
    }
}
