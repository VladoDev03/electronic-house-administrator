package org.example.service.implementations;

import org.example.dao.BuildingDao;
import org.example.dao.EmployeeDao;
import org.example.dto.Apartment.FullApartmentInfoDto;
import org.example.dto.Building.*;
import org.example.dto.Payment.NewPaymentDto;
import org.example.dto.Pet.FullPetInfoDto;
import org.example.dto.Resident.FullResidentInfoDto;
import org.example.dto.Resident.ResidentInBuildingDto;
import org.example.dto.Service.ServiceInfoDto;
import org.example.entity.*;
import org.example.service.contracts.BuildingService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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
                building.getApartments(),
                employee,
                building.getService()
        );

        updateBuilding(updatedBuilding);
    }

    @Override
    public FullBuildingInfoDto getBuildingWithApartmentsInfoWithResidentsInfo(long buildingId) {
        Building building = BuildingDao.getBuildingWithApartmentsWithResidentsWithSerivce(buildingId);

        FullBuildingInfoDto result = new FullBuildingInfoDto(
                building.getId(),
                building.getAddress(),
                building.getFloors(),
                building.getArea(),
                building.getApartments()
                        .stream()
                        .map(a -> {
                            FullApartmentInfoDto resultApartment = new FullApartmentInfoDto(
                                    a.getId(),
                                    a.getFloor(),
                                    a.getApartmentNumber(),
                                    a.getArea(),
                                    a.getResidents()
                                            .stream()
                                            .map(r -> {
                                                FullResidentInfoDto resultResident = new FullResidentInfoDto(
                                                        r.getFirstName(),
                                                        r.getLastName(),
                                                        r.getAge(),
                                                        r.isUsesElevator()
                                                );

                                                return resultResident;
                                            })
                                            .toList(),
                                    a.getOwners()
                                            .stream()
                                            .map(o -> {
                                                FullResidentInfoDto resultOwner = new FullResidentInfoDto(
                                                        o.getFirstName(),
                                                        o.getLastName(),
                                                        o.getAge(),
                                                        o.isUsesElevator()
                                                );

                                                return resultOwner;
                                            })
                                            .toList(),
                                    a.getPets()
                                            .stream()
                                            .map(p -> {
                                                FullPetInfoDto resultPet = new FullPetInfoDto(
                                                        p.getId(),
                                                        p.getUsesCommonArea()
                                                );

                                                return resultPet;
                                            })
                                            .toList()
                            );

                            return resultApartment;
                        })
                        .toList()
        );

        return result;
    }

    @Override
    public BuildingResidentsDto getBuildingResidents(long buildingId) {
        Building building = BuildingDao.getBuildingWithResidents(buildingId);

        List<ResidentInBuildingDto> residents = building.getApartments()
                .stream()
                .flatMap(a -> a.getResidents()
                        .stream()
                        .map(r -> new ResidentInBuildingDto(
                                r.getFirstName(),
                                r.getLastName(),
                                r.getAge()
                        )))
                .sorted(Comparator.comparing(ResidentInBuildingDto::getFirstName)
                        .thenComparing(ResidentInBuildingDto::getLastName)
                        .thenComparing(ResidentInBuildingDto::getAge))
                .toList();

        BuildingResidentsDto result = new BuildingResidentsDto(
                building.getAddress(),
                residents
        );

        return result;
    }

    @Override
    public List<NewPaymentDto> createPayments(long buildingId) {
        FullBuildingInfoDto buildingWithData = getBuildingWithApartmentsInfoWithResidentsInfo(buildingId);
        Building buildingWithService = BuildingDao.getBuildingWithServices(buildingId);

        List<NewPaymentDto> newPayments = new ArrayList<>();

        ServiceInfoDto service = new ServiceInfoDto(
                buildingWithService.getService().getPriceArea(),
                buildingWithService.getService().getPriceResident(),
                buildingWithService.getService().getPriceAnimal(),
                buildingWithService.getService().getPriceElevator(),
                buildingWithService.getService().getPriceAnimalCommonArea()
        );

        for (FullApartmentInfoDto apartment : buildingWithData.getApartments()) {
            double total = 0;

            for (FullPetInfoDto pet : apartment.getPets()) {
                if (pet.getUsesCommonArea()) {
                    total = total + service.getPriceAnimalCommonArea();
                } else {
                    total = total + service.getPriceAnimal();
                }
            }

            total = total + apartment.getArea() * service.getPriceArea();

            for (FullResidentInfoDto resident : apartment.getResidents()) {
                total = total + service.getPriceResident();

                if (resident.getUsesElevator()) {
                    total = total + service.getPriceElevator();
                }
            }

            NewPaymentDto payment = new NewPaymentDto(apartment.getId(), total, apartment.getApartmentNumber());
            newPayments.add(payment);
        }

        return newPayments;
    }
}
