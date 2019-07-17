package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.Employee;
import com.tw.apistackbase.repository.EmployeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeRepository mockEmployeeRepository;

    @Test
    public void should_return_employees_when_request_all_employees_api() throws Exception {
        List<Employee> mockEmployeeList = new ArrayList<>();
        mockEmployeeList.add(new Employee(10001, "Test", 15, "male", 6000));
        Mockito.when(mockEmployeeRepository.getEmployees()).thenReturn(mockEmployeeList);

        mockMvc.perform(get("/employees"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].id").value(10001));
    }

    @Test
    public void should_return_employee_whose_id_is_1_when_request_all_employees_api() throws Exception {
        List<Employee> mockEmployeeList = new ArrayList<>();
        mockEmployeeList.add(new Employee(10001, "Test", 15, "male", 6000));
        Mockito.when(mockEmployeeRepository.getEmployees()).thenReturn(mockEmployeeList);

        mockMvc.perform(get("/employees/10001"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(10001));
    }

    @Test
    public void should_return_employees_when_request_employees_pageable_api() throws Exception {
        List<Employee> mockEmployeeList = new ArrayList<>();
        mockEmployeeList.add(new Employee(10001, "Test", 15, "male", 6000));
        mockEmployeeList.add(new Employee(10002, "Test2", 17, "female", 7000));
        mockEmployeeList.add(new Employee(10003, "Test3", 19, "male", 8000));
        Mockito.when(mockEmployeeRepository.getEmployees()).thenReturn(mockEmployeeList);

        mockMvc.perform(get("/employees?page=2&pageSize=3"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].id").value(10002))
                .andExpect(jsonPath("$.[1].id").value(10003));
    }

    @Test
    public void should_return_gender_is_female_when_request_employees_by_gender_api() throws Exception {
        List<Employee> mockEmployeeList = new ArrayList<>();
        mockEmployeeList.add(new Employee(10001, "Test", 15, "male", 6000));
        mockEmployeeList.add(new Employee(10002, "Test2", 17, "female", 7000));
        mockEmployeeList.add(new Employee(10003, "Test3", 19, "male", 8000));
        Mockito.when(mockEmployeeRepository.getEmployees()).thenReturn(mockEmployeeList);

        mockMvc.perform(get("/employees?gender=female"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].gender").value("female"));
    }

    @Test
    public void should_return_employee_with_id_when_post_employee_api() throws Exception {
        List<Employee> mockEmployeeList = new ArrayList<>();
        mockEmployeeList.add(new Employee(10001, "Test", 15, "male", 6000));
        Mockito.when(mockEmployeeRepository.getEmployees()).thenReturn(mockEmployeeList);

        mockMvc.perform(post("/employees")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content("    {\n" +
                        "        \"name\": \"Test-add-name\",\n" +
                        "        \"age\": 19,\n" +
                        "        \"gender\": \"female\",\n" +
                        "        \"salary\": 5000\n" +
                        "    }"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(10002));
    }

    @Test
    public void should_return_employee_with_update_name_when_request_to_update_employee_by_id_api() throws Exception {
        List<Employee> mockEmployeeList = new ArrayList<>();
        mockEmployeeList.add(new Employee(10001, "Test", 15, "male", 6000));
        Mockito.when(mockEmployeeRepository.getEmployees()).thenReturn(mockEmployeeList);

        mockMvc.perform(put("/employees/10001")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content("    {\n" +
                        "        \"name\": \"Test-put-name\",\n" +
                        "        \"age\": 15,\n" +
                        "        \"gender\": \"male\",\n" +
                        "        \"salary\": 6000\n" +
                        "    }"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Test-put-name"));
    }

    @Test
    public void should_return_the_delete_company_when_request_delete_company_api() throws Exception {
        List<Employee> mockEmployeeList = new ArrayList<>();
        mockEmployeeList.add(new Employee(10001, "Test", 15, "male", 6000));
        Mockito.when(mockEmployeeRepository.getEmployees()).thenReturn(mockEmployeeList);

        mockMvc.perform(delete("/employees/10001")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Test"));
    }
}