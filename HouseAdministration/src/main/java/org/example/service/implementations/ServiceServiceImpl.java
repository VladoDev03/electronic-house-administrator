package org.example.service.implementations;

import org.example.dao.BuildingDao;
import org.example.dao.ServiceDao;
import org.example.dto.Service.CreateServiceDto;
import org.example.dto.Service.ServiceDto;
import org.example.dto.Service.UpdateServiceDto;
import org.example.entity.Building;
import org.example.entity.Service;
import org.example.exception.EntitiesAlreadyRelatedException;
import org.example.exception.EntityNotFoundException;
import org.example.service.contracts.ServiceService;

public class ServiceServiceImpl implements ServiceService {
    @Override
    public ServiceDto getServiceById(int id) throws EntityNotFoundException {
        Service service = ServiceDao.getServiceById(id);

        ServiceDto result = new ServiceDto(
                service.getId(),
                service.getPriceArea(),
                service.getPriceResident(),
                service.getPriceAnimal(),
                service.getPriceAnimalCommonArea(),
                service.getPriceElevator(),
                service.getBuilding()
        );

        return result;
    }

    @Override
    public ServiceDto createService(CreateServiceDto serviceDto) {
        Service service = new Service(
                serviceDto.getPriceArea(),
                serviceDto.getPriceResident(),
                serviceDto.getPriceAnimal(),
                serviceDto.getPriceAnimalCommonArea(),
                serviceDto.getPriceElevator(),
                serviceDto.getBuilding()
        );

        ServiceDao.createService(service);

        ServiceDto result = new ServiceDto(
                service.getId(),
                service.getPriceArea(),
                service.getPriceResident(),
                service.getPriceAnimal(),
                service.getPriceAnimalCommonArea(),
                service.getPriceElevator(),
                service.getBuilding()
        );

        return result;
    }

    @Override
    public void updateService(UpdateServiceDto serviceDto) {
        Service service = new Service(
                serviceDto.getId(),
                serviceDto.getPriceArea(),
                serviceDto.getPriceResident(),
                serviceDto.getPriceAnimal(),
                serviceDto.getPriceAnimalCommonArea(),
                serviceDto.getPriceElevator(),
                serviceDto.getBuilding()
        );

        ServiceDao.updateService(service);
    }

    @Override
    public void deleteService(long id) throws EntityNotFoundException {
        Service service = ServiceDao.getServiceById(id);
        ServiceDao.deleteService(service);
    }

    public void setServiceToBuilding(long serviceId, long buildingId) throws EntityNotFoundException, EntitiesAlreadyRelatedException {
        Service service = ServiceDao.getServiceById(serviceId);
        Building building = BuildingDao.getBuildingById(buildingId);

        if (service.getBuilding() != null && service.getBuilding().getId() == building.getId()) {
            throw new EntitiesAlreadyRelatedException(serviceId, buildingId);
        }

        UpdateServiceDto serviceDto = new UpdateServiceDto(
                service.getId(),
                service.getPriceArea(),
                service.getPriceResident(),
                service.getPriceAnimal(),
                service.getPriceAnimalCommonArea(),
                service.getPriceElevator(),
                building
        );

        updateService(serviceDto);
    }
}
