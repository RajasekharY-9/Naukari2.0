package com.mono.Naukari.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService{

    @Autowired
    CompanyRepository companyRepository;


    @Override
    public void createCompany(Company comp) {
        companyRepository.save(comp);
    }

    @Override
    public void deleteCompany(Integer id) {
companyRepository.deleteById(id);
    }

    @Override
    public String updateCompany(Integer id, Company company) {
        Optional<Company> comp=companyRepository.findById(id);
        if(comp.isPresent()){
            Company c=comp.get();
            c.setDescription(company.getDescription());
c.setName(company.getName());
     c.setJobs(company.getJobs());
     companyRepository.save(c);
        }
else{
            System.out.println("No Companies found");
        }

        return "Company details modified !!!";
    }

    @Override
    public Company getCompany(Integer id) {
        return companyRepository.getReferenceById(id);
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }
}
