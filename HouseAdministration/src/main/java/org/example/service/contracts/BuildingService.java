package org.example.service.contracts;

import org.example.dto.Building.*;

public interface BuildingService {
    BuildingDto createBuilding(CreateBuildingDto buildingDto);
    void deleteBuilding(long buildingId);
    BuildingDto getBuildingById(long buildingId);
    void updateBuilding(UpdateBuildingDto buildingToUpdate);
    void assignBuildingToEmployee(long employeeId, long buildingId);
    FullBuildingInfoDto getBuildingWithApartmentsInfoWithResidentsInfo(long buildingId);
    BuildingResidentsDto getBuildingResidents(long buildingId);
}
