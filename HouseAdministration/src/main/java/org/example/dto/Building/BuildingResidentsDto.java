package org.example.dto.Building;

import org.example.dto.Resident.ResidentDto;
import org.example.dto.Resident.ResidentInBuildingDto;

import java.util.List;

public class BuildingResidentsDto {
    private final String buildingAdress;
    private final List<ResidentInBuildingDto> residents;

    public BuildingResidentsDto(String buildingAdress, List<ResidentInBuildingDto> residents) {
        this.buildingAdress = buildingAdress;
        this.residents = residents;
    }

    public String getBuildingAdress() {
        return buildingAdress;
    }

    public List<ResidentInBuildingDto> getResidents() {
        return residents;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(this.buildingAdress).append('\n');
        residents.forEach(residentDto -> sb.append(residentDto.toString()));

        return sb.toString();
    }
}
