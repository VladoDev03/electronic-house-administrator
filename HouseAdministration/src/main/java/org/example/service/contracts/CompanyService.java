package org.example.service.contracts;

import org.example.dto.CreateCompanyDto;

public interface CompanyService {
    CreateCompanyDto createCompany(CreateCompanyDto companyDto);
}
