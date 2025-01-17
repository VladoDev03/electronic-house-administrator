package org.example.service.implementations;

import org.example.dao.ApartmentDao;
import org.example.dao.BuildingDao;
import org.example.dao.ResidentDao;
import org.example.dto.Apartment.ApartmentDto;
import org.example.dto.Apartment.CreateApartmentDto;
import org.example.dto.Apartment.UpdateApartmentDto;
import org.example.entity.Apartment;
import org.example.entity.Building;
import org.example.entity.Resident;
import org.example.service.contracts.ApartmentService;

public class ApartmentServiceImpl implements ApartmentService {
    @Override
    public ApartmentDto getApartmentById(long apartmentId) {
        Apartment apartment = ApartmentDao.getApartmentById(apartmentId);

        ApartmentDto apartmentDto = new ApartmentDto(
                apartment.getId(),
                apartment.getFloor(),
                apartment.getApartmentNumber(),
                apartment.getArea(),
                apartment.getHasPet(),
                apartment.getBuilding(),
                apartment.getResidents(),
                apartment.getOwners(),
                apartment.getPayments()
        );

        return apartmentDto;
    }

    @Override
    public ApartmentDto createApartment(CreateApartmentDto apartmentDto) {
        Apartment apartment = new Apartment(
                apartmentDto.getFloor(),
                apartmentDto.getApartmentNumber(),
                apartmentDto.getArea(),
                apartmentDto.getHasPet(),
                apartmentDto.getBuilding(),
                apartmentDto.getResidents(),
                apartmentDto.getPayments(),
                apartmentDto.getOwners()
        );

        ApartmentDao.createApartment(apartment);

        ApartmentDto result = new ApartmentDto(
                apartment.getId(),
                apartment.getFloor(),
                apartment.getApartmentNumber(),
                apartment.getArea(),
                apartment.getHasPet(),
                apartment.getBuilding(),
                apartment.getResidents(),
                apartment.getOwners(),
                apartment.getPayments()
        );

        return result;
    }

    @Override
    public void deleteApartment(long apartmentId) {
        Apartment apartment = ApartmentDao.getApartmentById(apartmentId);
        ApartmentDao.deleteApartment(apartment);
    }

    @Override
    public void updateApartment(UpdateApartmentDto apartmentDto) {
        Apartment apartment = new Apartment(
                apartmentDto.getId(),
                apartmentDto.getFloor(),
                apartmentDto.getApartmentNumber(),
                apartmentDto.getArea(),
                apartmentDto.getHasPet(),
                apartmentDto.getBuilding(),
                apartmentDto.getResidents(),
                apartmentDto.getPayments(),
                apartmentDto.getOwners()
        );

        ApartmentDao.updateApartment(apartment);
    }

    @Override
    public void addApartmentToBuilding(long apartmentId, long buildingId) {
        Apartment apartment = ApartmentDao.getApartmentById(apartmentId);
        Building building = BuildingDao.getBuildingById(buildingId);

        UpdateApartmentDto apartmentDto = new UpdateApartmentDto(
                apartment.getId(),
                apartment.getFloor(),
                apartment.getApartmentNumber(),
                apartment.getArea(),
                apartment.getHasPet(),
                building,
                apartment.getResidents(),
                apartment.getOwners(),
                apartment.getPayments()
        );

        updateApartment(apartmentDto);
    }

    @Override
    public void setApartmentOwner(long apartmentId, long ownerId) {
        Apartment apartment = ApartmentDao.getApartmentWithOwners(apartmentId);
        Resident owner = ResidentDao.getResidentById(ownerId);

        apartment.getOwners().add(owner);

        UpdateApartmentDto apartmentDto = new UpdateApartmentDto(
                apartment.getId(),
                apartment.getFloor(),
                apartment.getApartmentNumber(),
                apartment.getArea(),
                apartment.getHasPet(),
                apartment.getBuilding(),
                apartment.getResidents(),
                apartment.getOwners(),
                apartment.getPayments()
        );

        updateApartment(apartmentDto);
    }
}
