package org.example.service.contracts;

import org.example.dto.Apartment.ApartmentDto;
import org.example.dto.Apartment.CreateApartmentDto;
import org.example.dto.Apartment.UpdateApartmentDto;
import org.example.exception.EntitiesAlreadyRelatedException;
import org.example.exception.EntityNotFoundException;

public interface ApartmentService {
    ApartmentDto getApartmentById(long apartmentId) throws EntityNotFoundException;
    ApartmentDto createApartment(CreateApartmentDto apartmentDto);
    void deleteApartment(long apartmentId) throws EntityNotFoundException;
    void updateApartment(UpdateApartmentDto apartmentDto);
    void addApartmentToBuilding(long apartmentId, long buildingId) throws EntityNotFoundException, EntitiesAlreadyRelatedException;
    void setApartmentOwner(long apartmentId, long ownerId) throws EntityNotFoundException, EntitiesAlreadyRelatedException;
    void addResidentToApartment(long residentId, long apartmentId) throws EntityNotFoundException, EntitiesAlreadyRelatedException;
}
