package com.mono.Naukari.company;

import java.util.List;

public interface CompanyService {

    void createCompany(Company comp);

    void deleteCompany(Integer id);

    String updateCompany(Integer id,Company company);

    Company getCompany(Integer id);

    List<Company> getAllCompanies();
}
