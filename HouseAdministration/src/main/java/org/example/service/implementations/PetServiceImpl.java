package org.example.service.implementations;

import org.example.dao.ApartmentDao;
import org.example.dao.PetDao;
import org.example.dto.Pet.CreatePetDto;
import org.example.dto.Pet.PetDto;
import org.example.dto.Pet.UpdatePetDto;
import org.example.entity.Apartment;
import org.example.entity.Pet;
import org.example.service.contracts.PetService;

public class PetServiceImpl implements PetService {
    @Override
    public PetDto getPetById(long petId) {
        Pet pet = PetDao.getPetById(petId);

        PetDto result = new PetDto(
                pet.getId(),
                pet.getUsesCommonArea(),
                pet.getApartment()
        );

        return result;
    }

    @Override
    public PetDto createPet(CreatePetDto petDto) {
        Pet pet = new Pet(
                petDto.getUsesCommonArea(),
                petDto.getApartment()
        );

        PetDao.createPet(pet);

        PetDto result = new PetDto(
                pet.getId(),
                pet.getUsesCommonArea(),
                pet.getApartment()
        );

        return result;
    }

    @Override
    public void updatePet(UpdatePetDto petDto) {
        Pet pet = new Pet(
                petDto.getId(),
                petDto.getUsesCommonArea(),
                petDto.getApartment()
        );

        PetDao.updatePet(pet);
    }

    @Override
    public void deletePet(long petId) {
        Pet pet = PetDao.getPetById(petId);
        PetDao.deletePet(pet);
    }

    @Override
    public void addPetToApartment(long apartmentId, long petId) {
        Apartment apartment = ApartmentDao.getApartmentById(apartmentId);
        Pet pet = PetDao.getPetById(petId);

        UpdatePetDto updatePetDto = new UpdatePetDto(
                pet.getId(),
                pet.getUsesCommonArea(),
                apartment
        );

        updatePet(updatePetDto);
    }
}
