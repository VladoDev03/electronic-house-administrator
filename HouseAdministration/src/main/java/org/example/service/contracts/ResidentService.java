package org.example.service.contracts;

import org.example.dto.Resident.CreateResidentDto;
import org.example.dto.Resident.ResidentDto;
import org.example.dto.Resident.UpdateResidentDto;
import org.example.entity.Apartment;

import java.util.Set;

public interface ResidentService {
    ResidentDto getResidentById(int id);
    ResidentDto createResident(CreateResidentDto residentDto);
    void updateResident(UpdateResidentDto residentDto);
    void deleteResident(long id);
    Set<Apartment> getResidentOwnedApartments(long residentId);
}
