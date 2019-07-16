package com.tw.apistackbase.model;

import java.util.ArrayList;
import java.util.List;

public class Company {

    private long companyId;

    private String companyName;

    private List<Employee> employees;

    private int employeeNumber;

    public Company() {
    }

    public Company(long companyId, String companyName, List<Employee> employees, int employeeNumber) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.employees = employees;
        this.employeeNumber = employeeNumber;
    }

    public Company(String companyName,List<Employee> employees, int employeeNumber) {
        this.companyName = companyName;
        this.employees = employees;
        this.employeeNumber = employeeNumber;
    }

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                ", employees=" + employees +
                ", employeeNumber=" + employeeNumber +
                '}';
    }
}
