package org.example.dto.Building;

import org.example.dto.Apartment.FullApartmentInfoDto;

import java.util.List;

public class FullBuildingInfoDto {
    private final String address;
    private final int floors;
    private final double area;
    private final List<FullApartmentInfoDto> apartments;

    public FullBuildingInfoDto(String address, int floors, double area, List<FullApartmentInfoDto> apartments) {
        this.address = address;
        this.floors = floors;
        this.area = area;
        this.apartments = apartments;
    }

    public String getAddress() {
        return address;
    }

    public int getFloors() {
        return floors;
    }

    public double getArea() {
        return area;
    }

    public List<FullApartmentInfoDto> getApartments() {
        return apartments;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Address: ").append(address).append("\n");
        sb.append("Floors: ").append(floors).append("\n");
        sb.append("Area: ").append(area).append("\n");
        sb.append("Apartments: ").append("\n");
        apartments.forEach(a -> sb.append(a.toString()).append("\n"));

        return sb.toString();
    }
}
