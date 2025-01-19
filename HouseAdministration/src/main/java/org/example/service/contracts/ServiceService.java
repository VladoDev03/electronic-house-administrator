package org.example.service.contracts;

import org.example.dto.Service.CreateServiceDto;
import org.example.dto.Service.ServiceDto;
import org.example.dto.Service.UpdateServiceDto;

public interface ServiceService {
    ServiceDto getServiceById(int id);
    ServiceDto createService(CreateServiceDto serviceDto);
    void updateService(UpdateServiceDto serviceDto);
    void deleteService(long id);
    void setServiceToBuilding(long serviceId, long buildingId);
}
