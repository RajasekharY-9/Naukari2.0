package com.mono.Naukari.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @PostMapping("/companies-create")
    String createCompany(@RequestBody Company comp){
companyService.createCompany(comp);
return "Company Created with ID : " +comp.getId();
    }
@DeleteMapping("/companies-delete/{id}")
    String  deleteCompany(@PathVariable Integer id){
        companyService.deleteCompany(id);
        return "Company has been deleted ";
}

@PutMapping("/companies/{id}/comp")
    String updateCompany(@PathVariable Integer id,@RequestBody Company company){
      String msg=  companyService.updateCompany(id,company);
        return msg;
}
@GetMapping("/company/{id}")
    Company getCompany(@PathVariable Integer id){
        return companyService.getCompany(id);
}

@GetMapping("/company-all")
    List<Company> getAllCompanies(){
        return companyService.getAllCompanies();
}
}
