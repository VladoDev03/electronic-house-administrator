package org.example.service.contracts;

import org.example.dto.Apartment.ApartmentDto;
import org.example.dto.Apartment.CreateApartmentDto;
import org.example.dto.Apartment.UpdateApartmentDto;

public interface ApartmentService {
    ApartmentDto getApartmentById(long apartmentId);
    ApartmentDto createApartment(CreateApartmentDto apartmentDto);
    void deleteApartment(long apartmentId);
    void updateApartment(UpdateApartmentDto apartmentDto);
    void addApartmentToBuilding(long apartmentId, long buildingId);
}
