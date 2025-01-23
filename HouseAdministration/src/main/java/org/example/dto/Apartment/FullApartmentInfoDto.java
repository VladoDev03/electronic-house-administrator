package org.example.dto.Apartment;

import org.example.dto.Pet.FullPetInfoDto;
import org.example.dto.Resident.FullResidentInfoDto;

import java.util.List;

public class FullApartmentInfoDto {
    private long id;
    private final int floor;
    private final int apartmentNumber;
    private final int area;
    private final boolean hasPet;
    private final List<FullResidentInfoDto> residents;
    private final List<FullResidentInfoDto> owners;
    private final List<FullPetInfoDto> pets;

    public FullApartmentInfoDto(
            int floor,
            int apartmentNumber,
            int area,
            boolean hasPet,
            List<FullResidentInfoDto> residents,
            List<FullResidentInfoDto> owners,
            List<FullPetInfoDto> pets
    ) {
        this.floor = floor;
        this.apartmentNumber = apartmentNumber;
        this.area = area;
        this.hasPet = hasPet;
        this.residents = residents;
        this.owners = owners;
        this.pets = pets;
    }

    public FullApartmentInfoDto(
            long id,
            int floor,
            int apartmentNumber,
            int area,
            boolean hasPet,
            List<FullResidentInfoDto> residents,
            List<FullResidentInfoDto> owners,
            List<FullPetInfoDto> pets
    ) {
        this(floor, apartmentNumber, area, hasPet, residents, owners, pets);
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public int getFloor() {
        return floor;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public int getArea() {
        return area;
    }

    public boolean getHasPet() {
        return hasPet;
    }

    public List<FullResidentInfoDto> getResidents() {
        return residents;
    }

    public List<FullResidentInfoDto> getOwners() {
        return owners;
    }

    public List<FullPetInfoDto> getPets() {
        return pets;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("\tFloor: ").append(floor).append(" ").append("\n");
        sb.append("\tAparment Number: ").append(apartmentNumber).append("\n");
        sb.append("\tArea: ").append(area).append("\n");
        sb.append("\tHas Pet: ").append(hasPet).append("\n");
        sb.append("\tResidents: ").append("\n");
        residents.forEach(r -> sb.append(r.toString()).append("\n"));
        sb.append("\tOwners: ").append("\n");
        owners.forEach(o -> sb.append(o.toString()).append("\n"));
        sb.append("\tPets: ").append("\n");
        pets.forEach(p -> sb.append(p.toString()).append("\n"));

        return sb.toString();
    }
}
