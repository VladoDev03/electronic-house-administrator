package org.example.service.contracts;

import org.example.dto.Service.CreateServiceDto;
import org.example.dto.Service.ServiceDto;
import org.example.dto.Service.UpdateServiceDto;
import org.example.exception.EntitiesAlreadyRelatedException;
import org.example.exception.EntityNotFoundException;

public interface ServiceService {
    ServiceDto getServiceById(int id) throws EntityNotFoundException;
    ServiceDto createService(CreateServiceDto serviceDto);
    void updateService(UpdateServiceDto serviceDto);
    void deleteService(long id) throws EntityNotFoundException;
    void setServiceToBuilding(long serviceId, long buildingId) throws EntityNotFoundException, EntitiesAlreadyRelatedException;
}
