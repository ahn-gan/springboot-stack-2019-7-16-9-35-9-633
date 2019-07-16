package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.Company;
import com.tw.apistackbase.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CompanyController {

    @Autowired
    private CompanyRepository companyRepository;

    private List<Company> companies;

    @GetMapping("/companies")
    public ResponseEntity getCompanies(@RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value = "pageSize", defaultValue = "0") int pageSize) {
        List<Company> companies = companyRepository.getCompanies();
        return (page == 0 && pageSize == 0 || pageSize > companies.size()) ? ResponseEntity.ok(companyRepository.getCompanies()) : ResponseEntity.ok(companies.subList(page - 1, pageSize));
    }

    @GetMapping("/companies/{companyId}")
    public ResponseEntity findCompanyById(@PathVariable(name = "companyId") long companyId) {
        companies = companyRepository.getCompanies();
        if (!companies.isEmpty()) {
            Company searchCompany = companies.stream().filter(v -> v.getCompanyId() == companyId).findFirst().orElse(null);
            return ResponseEntity.ok(searchCompany);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/companies/{companyId}/employees")
    public ResponseEntity findEmployeesByCompanyId(@PathVariable(name = "companyId") long companyId) {
        companies = companyRepository.getCompanies();
        if (!companies.isEmpty()) {
            Company searchCompany = companies.stream().filter(v -> v.getCompanyId() == companyId).findFirst().orElse(null);
            return ResponseEntity.ok(searchCompany.getEmployees());
        }
        return ResponseEntity.notFound().build();
    }

}