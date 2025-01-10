package org.example.service.implementations;

import org.example.dao.BuildingDao;
import org.example.dto.Building.BuildingDto;
import org.example.dto.Building.CreateBuildingDto;
import org.example.dto.Building.UpdateBuildingDto;
import org.example.entity.Building;
import org.example.service.contracts.BuildingService;

public class BuildingServiceImpl implements BuildingService {
    @Override
    public BuildingDto createBuilding(CreateBuildingDto buildingDto) {
        Building building = new Building(buildingDto.getAddress(), buildingDto.getFloors(), buildingDto.getArea(), buildingDto.getApartments(), buildingDto.getResponsibleEmployee());
        BuildingDao.createBuilding(building);

        BuildingDto result = new BuildingDto(building.getId(), building.getAddress(), building.getFloors(), building.getArea(), building.getApartments(), building.getResponsibleEmployee());

        return result;
    }

    @Override
    public void deleteBuilding(long buildingId) {
        Building building = BuildingDao.getBuildingById(buildingId);
        BuildingDao.deleteBuilding(building);
    }

    @Override
    public BuildingDto getBuildingById(long buildingId) {
        Building building = BuildingDao.getBuildingById(buildingId);
        BuildingDto result = new BuildingDto(building.getId(), building.getAddress(), building.getFloors(), building.getArea(), building.getApartments(), building.getResponsibleEmployee());

        return result;
    }

    @Override
    public void updateBuilding(UpdateBuildingDto buildingToUpdate) {
        Building building = new Building(buildingToUpdate.getId(), buildingToUpdate.getAddress(), buildingToUpdate.getFloors(), buildingToUpdate.getArea(), buildingToUpdate.getApartments(), buildingToUpdate.getResponsibleEmployee());
        BuildingDao.updateBuilding(building);
    }
}
