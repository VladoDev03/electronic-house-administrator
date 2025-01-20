package org.example.dto.Building;

public class BuildingInfoDto {
    private final String address;
    private final int floors;
    private final double area;

    public BuildingInfoDto(String address, int floors, double area) {
        this.address = address;
        this.floors = floors;
        this.area = area;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("\t\tAddress: ").append(address).append("\n");
        sb.append("\t\tFloors: ").append(floors).append("\n");
        sb.append("\t\tArea: ").append(area).append("\n");

        return sb.toString();
    }
}
