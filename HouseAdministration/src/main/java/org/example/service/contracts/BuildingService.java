package org.example.service.contracts;

import org.example.dto.Building.BuildingDto;
import org.example.dto.Building.CreateBuildingDto;
import org.example.dto.Building.UpdateBuildingDto;

public interface BuildingService {
    BuildingDto createBuilding(CreateBuildingDto buildingDto);
    void deleteBuilding(long buildingId);
    BuildingDto getBuildingById(long buildingId);
    void updateBuilding(UpdateBuildingDto buildingToUpdate);
}
