package org.example.dto.Resident;

import org.example.entity.Apartment;

import java.util.Set;

public class CreateResidentDto {
    private final String firstName;
    private final String lastName;
    private final int age;
    private final boolean usesElevator;
    private final Set<Apartment> ownedApartments;
    private final Apartment apartment;

    public CreateResidentDto(String firstName, String lastName, int age, boolean usesElevator, Set<Apartment> ownedApartments, Apartment apartment) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.usesElevator = usesElevator;
        this.ownedApartments = ownedApartments;
        this.apartment = apartment;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
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