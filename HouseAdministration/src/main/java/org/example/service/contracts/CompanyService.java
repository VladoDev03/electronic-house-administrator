package org.example.service.contracts;

import org.example.dto.CompanyDto;
import org.example.dto.CreateCompanyDto;

public interface CompanyService {
    CreateCompanyDto createCompany(CreateCompanyDto companyDto);
    void deleteCompany(long companyId);
    CompanyDto getCompanyById(long companyId);
}
