package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.Employee;
import com.tw.apistackbase.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    private List<Employee> employees;

//    @PostMapping("/employees")
//    public ResponseEntity createEmployee (@RequestBody Employee employee) {
//        employees = employeeRepository.getEmployees();
//        employees.add(employee);
//        return ResponseEntity.ok(employees);
//    }

    @GetMapping("/employees/{employeeId}")
    public ResponseEntity findEmployeeById(@PathVariable(name = "employeeId") long employeeId) {
        employees = employeeRepository.getEmployees();
        Employee resultEmployee = employees.stream().filter(v -> v.getId() == employeeId).findFirst().orElse(null);
        return ResponseEntity.ok(resultEmployee);
    }

    @GetMapping("/employees")
    public ResponseEntity findEmployees(@RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value = "pageSize", defaultValue = "0") int pageSize, @RequestParam(value = "gender", defaultValue = "") String gender) {
        employees = employeeRepository.getEmployees();
        if (!gender.isEmpty()) {
            employees = employees.stream().filter(e -> e.getGender().equals(gender)).collect(Collectors.toList());
        }
        employees = (page == 0 || pageSize == 0 || pageSize > employees.size()) ? employees : employees.subList(page - 1, pageSize);
        return ResponseEntity.ok(employees);
    }

//    @PutMapping("/employees/{employeeId}")
//    public ResponseEntity updateEmployee(@PathVariable(name = "employeeId") long employeeId, @RequestBody Employee employee) {
//        Employee targetEmployee = employees.stream().filter(v -> v.getId() == employeeId).findFirst().orElse(null);
//        if (targetEmployee != null) {
//            BeanUtils.copyProperties(employee, targetEmployee);
//            return ResponseEntity.ok(employees);
//        }
//        return ResponseEntity.notFound().build();
//    }
}
