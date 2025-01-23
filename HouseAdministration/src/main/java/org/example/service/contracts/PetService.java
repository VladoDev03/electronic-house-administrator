package org.example.service.contracts;

import org.example.dto.Pet.CreatePetDto;
import org.example.dto.Pet.PetDto;
import org.example.dto.Pet.UpdatePetDto;

public interface PetService {
    PetDto getPetById(long petId);
    PetDto createPet(CreatePetDto petDto);
    void updatePet(UpdatePetDto petDto);
    void deletePet(long petId);
}
