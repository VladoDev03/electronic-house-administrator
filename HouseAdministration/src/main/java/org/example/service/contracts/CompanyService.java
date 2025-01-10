package org.example.service.contracts;

import org.example.dto.Company.CompanyDto;
import org.example.dto.Company.CreateCompanyDto;
import org.example.dto.Company.UpdateCompanyDto;
import org.example.entity.Employee;

import java.util.Set;

public interface CompanyService {
    CompanyDto createCompany(CreateCompanyDto companyDto);
    void deleteCompany(long companyId);
    CompanyDto getCompanyById(long companyId);
    void updateCompany(UpdateCompanyDto companyToUpdate);
    Set<Employee> getCompanyEmployees(long id);
}
