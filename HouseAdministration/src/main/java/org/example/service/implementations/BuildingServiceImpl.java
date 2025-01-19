package org.example.service.implementations;

import org.example.dao.BuildingDao;
import org.example.dao.EmployeeDao;
import org.example.dto.Building.BuildingDto;
import org.example.dto.Building.CreateBuildingDto;
import org.example.dto.Building.UpdateBuildingDto;
import org.example.entity.Building;
import org.example.entity.Employee;
import org.example.service.contracts.BuildingService;

import java.util.HashSet;

public class BuildingServiceImpl implements BuildingService {
    @Override
    public BuildingDto createBuilding(CreateBuildingDto buildingDto) {
        Building building = new Building(
                buildingDto.getAddress(),
                buildingDto.getFloors(),
                buildingDto.getArea(),
                buildingDto.getApartments(),
                buildingDto.getResponsibleEmployee(),
                buildingDto.getService()
        );

        BuildingDao.createBuilding(building);

        BuildingDto result = new BuildingDto(
                building.getId(),
                building.getAddress(),
                building.getFloors(),
                building.getArea(),
                building.getApartments(),
                building.getResponsibleEmployee(),
                building.getService()
        );

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

        BuildingDto result = new BuildingDto(
                building.getId(),
                building.getAddress(),
                building.getFloors(),
                building.getArea(),
                building.getApartments(),
                building.getResponsibleEmployee(),
                building.getService()
        );

        return result;
    }

    @Override
    public void updateBuilding(UpdateBuildingDto buildingToUpdate) {
        Building building = new Building(
                buildingToUpdate.getId(),
                buildingToUpdate.getAddress(),
                buildingToUpdate.getFloors(),
                buildingToUpdate.getArea(),
                buildingToUpdate.getApartments(),
                buildingToUpdate.getResponsibleEmployee(),
                buildingToUpdate.getService()
        );

        BuildingDao.updateBuilding(building);
    }

    @Override
    public void assignBuildingToEmployee(long employeeId, long buildingId) {
        Employee employee = EmployeeDao.getEmployeeById(employeeId);
        Building building = BuildingDao.getBuildingById(buildingId);

        UpdateBuildingDto updatedBuilding = new UpdateBuildingDto(
                building.getId(),
                building.getAddress(),
                building.getFloors(),
                building.getArea(),
                new HashSet<>(),
                employee,
                building.getService()
        );

        updateBuilding(updatedBuilding);
    }
}
