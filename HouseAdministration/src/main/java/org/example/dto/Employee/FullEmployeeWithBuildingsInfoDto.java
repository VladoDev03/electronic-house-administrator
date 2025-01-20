package org.example.dto.Employee;

import org.example.dto.Building.BuildingInfoDto;

import java.util.List;

public class FullEmployeeWithBuildingsInfoDto {
    private final String firstName;
    private final String lastName;
    private final List<BuildingInfoDto> buildings;

    public FullEmployeeWithBuildingsInfoDto(String firstName, String lastName, List<BuildingInfoDto> buildings) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.buildings = buildings;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<BuildingInfoDto> getBuildings() {
        return buildings;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("\tFull Name: ").append(this.getFirstName()).append(" ").append(this.getLastName()).append("\n");
        sb.append("\tBuildings: ").append("\n");
        buildings.forEach(b -> sb.append(b.toString()).append("\n"));

        return sb.toString();
    }
}
