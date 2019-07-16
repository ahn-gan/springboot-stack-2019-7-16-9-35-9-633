package com.tw.apistackbase.controller;

import com.tw.apistackbase.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyController {

    @Autowired
    private CompanyRepository companyRepository;

    @GetMapping("/companies")
    public ResponseEntity getCompanies() {
        return ResponseEntity.ok(companyRepository.getCompanies());
    }
}
