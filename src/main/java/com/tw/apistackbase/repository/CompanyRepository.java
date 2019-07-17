package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.Company;
import com.tw.apistackbase.model.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CompanyRepository {

    private List<Company> companies;

    public CompanyRepository() {
        this.companies = new ArrayList<>();
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(10001, "Test", 15, "male", 6000));
        companies.add(new Company(1111, "OOCL",employees, employees.size()));
        List<Employee> employees2 = new ArrayList<>();
        employees2.add(new Employee(10002, "Test02", 15, "male", 7000));
        companies.add(new Company(1112, "tencent", employees2, employees.size()));
        List<Employee> employees3 = new ArrayList<>();
        employees3.add(new Employee(10003, "Test03", 15, "male", 8000));
        companies.add(new Company(1113, "baidu", employees3, employees.size()));
    }

    public List<Company> getCompanies() {
        return companies;
    }
}
