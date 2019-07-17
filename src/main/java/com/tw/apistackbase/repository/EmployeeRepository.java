package com.tw.apistackbase.repository;

import com.tw.apistackbase.model.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeRepository {

    private List<Employee> employees = new ArrayList<>();

    public EmployeeRepository() {
        employees.add(new Employee(10001, "Test01-name", 15, "male", 6000));
        employees.add(new Employee(10002, "Test02-name", 20, "male", 7000));
        employees.add(new Employee(10003, "Test03-name", 18, "female", 6500));
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
