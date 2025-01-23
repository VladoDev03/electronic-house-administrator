package org.example.dto.Pet;

import org.example.entity.Apartment;

public class CreatePetDto {
    private final boolean usesCommonArea;
    private final Apartment apartment;

    public CreatePetDto(boolean usesCommonArea, Apartment apartment) {
        this.usesCommonArea = usesCommonArea;
        this.apartment = apartment;
    }

    public boolean getUsesCommonArea() {
        return usesCommonArea;
    }

    public Apartment getApartment() {
        return apartment;
    }
}
