package org.example.service.implementations;

import org.example.dao.ResidentDao;
import org.example.dto.Resident.CreateResidentDto;
import org.example.dto.Resident.ResidentDto;
import org.example.dto.Resident.UpdateResidentDto;
import org.example.entity.Apartment;
import org.example.entity.Resident;
import org.example.service.contracts.ResidentService;

import java.util.Set;

public class ResidentServiceImpl implements ResidentService {
    @Override
    public ResidentDto getResidentById(int id) {
        Resident resident = ResidentDao.getResidentById(id);

        ResidentDto residentDto = new ResidentDto(
                resident.getId(),
                resident.getFirstName(),
                resident.getLastName(),
                resident.getAge(),
                resident.isUsesElevator(),
                resident.getOwnedApartments(),
                resident.getApartment()
        );

        return residentDto;
    }

    @Override
    public ResidentDto createResident(CreateResidentDto residentDto) {
        Resident resident = new Resident(
                residentDto.getFirstName(),
                residentDto.getLastName(),
                residentDto.getAge(),
                residentDto.isUsesElevator(),
                residentDto.getOwnedApartments(),
                residentDto.getApartment()
        );

        ResidentDao.createResident(resident);

        ResidentDto result = new ResidentDto(
                resident.getId(),
                resident.getFirstName(),
                resident.getLastName(),
                resident.getAge(),
                resident.isUsesElevator(),
                resident.getOwnedApartments(),
                resident.getApartment()
        );

        return result;
    }

    @Override
    public void updateResident(UpdateResidentDto residentDto) {
        Resident resident = new Resident(
                residentDto.getId(),
                residentDto.getFirstName(),
                residentDto.getLastName(),
                residentDto.getAge(),
                residentDto.isUsesElevator(),
                residentDto.getOwnedApartments(),
                residentDto.getApartment()
        );

        ResidentDao.updateResident(resident);
    }

    @Override
    public void deleteResident(long id) {
        Resident resident = ResidentDao.getResidentById(id);
        ResidentDao.deleteResident(resident);
    }

    @Override
    public Set<Apartment> getResidentOwnedApartments(long residentId) {
        Set<Apartment> result = ResidentDao.getResidentOwnedApartments(residentId);
        return result;
    }
}
