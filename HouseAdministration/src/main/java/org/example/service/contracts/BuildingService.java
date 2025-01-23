package org.example.service.contracts;

import org.example.dto.Building.*;
import org.example.dto.Payment.NewPaymentDto;
import org.example.exception.EntitiesAlreadyRelatedException;
import org.example.exception.EntityNotFoundException;

import java.util.List;

public interface BuildingService {
    BuildingDto createBuilding(CreateBuildingDto buildingDto);
    void deleteBuilding(long buildingId) throws EntityNotFoundException;
    BuildingDto getBuildingById(long buildingId) throws EntityNotFoundException;
    void updateBuilding(UpdateBuildingDto buildingToUpdate);
    void assignBuildingToEmployee(long employeeId, long buildingId) throws EntityNotFoundException, EntitiesAlreadyRelatedException;
    FullBuildingInfoDto getBuildingWithApartmentsInfoWithResidentsInfo(long buildingId) throws EntityNotFoundException;
    BuildingResidentsDto getBuildingResidents(long buildingId) throws EntityNotFoundException;
    List<NewPaymentDto> createPayments(long buildingId) throws EntityNotFoundException;
}
