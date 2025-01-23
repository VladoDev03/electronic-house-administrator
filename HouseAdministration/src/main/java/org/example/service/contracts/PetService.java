package org.example.service.contracts;

import org.example.dto.Pet.CreatePetDto;
import org.example.dto.Pet.PetDto;
import org.example.dto.Pet.UpdatePetDto;
import org.example.exception.EntitiesAlreadyRelatedException;
import org.example.exception.EntityNotFoundException;

public interface PetService {
    PetDto getPetById(long petId) throws EntityNotFoundException;
    PetDto createPet(CreatePetDto petDto);
    void updatePet(UpdatePetDto petDto);
    void deletePet(long petId) throws EntityNotFoundException;
    void addPetToApartment(long apartmentId, long petId) throws EntityNotFoundException, EntitiesAlreadyRelatedException;
}
