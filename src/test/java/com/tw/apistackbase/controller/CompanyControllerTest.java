package com.tw.apistackbase.controller;

import com.tw.apistackbase.model.Company;
import com.tw.apistackbase.model.Employee;
import com.tw.apistackbase.repository.CompanyRepository;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CompanyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CompanyRepository mockCompanyRepository;

    private List<Company> mockCompanies;

//    @BeforeEach
//    void setUpData() {
//        mockCompanies = new ArrayList<>();
//        List<Employee> employees = new ArrayList<>();
//        employees.add(new Employee(10002, "Test", 15, "male", 6000));
//        mockCompanies.add(new Company(1111, "OOCL", employees, 1));
//    }

    @Test
    public void should_return_companies_when_request_all_companies_api() throws Exception {
        List<Company> mockCompanies= new ArrayList<>();
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(10002, "Test", 15, "male", 6000));
        mockCompanies.add(new Company(1111, "OOCL", employees, 1));
        Mockito.when(mockCompanyRepository.getCompanies()).thenReturn(mockCompanies);

        mockMvc.perform(get("/companies"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"companyId\":1111,\"companyName\":\"OOCL\",\"employees\":[{\"id\":10002,\"name\":\"Test\",\"age\":15,\"gender\":\"male\"}],\"employeeNumber\":1}]"));
    }

    @Test
    public void should_return_companies_which_company_id_is_123_when_request_companies_with_id_api() throws Exception {
        List<Company> mockCompanies= new ArrayList<>();
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(10002, "Test", 15, "male", 6000));
        mockCompanies.add(new Company(123, "OOCL", employees, employees.size()));
        Mockito.when(mockCompanyRepository.getCompanies()).thenReturn(mockCompanies);

        mockMvc.perform(get("/companies/123"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{\"companyId\":123,\"companyName\":\"OOCL\",\"employees\":[{\"id\":10002,\"name\":\"Test\",\"age\":15,\"gender\":\"male\"}],\"employeeNumber\":1}"));
    }

    @Test
    public void should_return_employees_of_company_id_is_123_when_request_companies_with_certain_company_id_api() throws Exception {
        List<Company> mockCompanies= new ArrayList<>();
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(10002, "Test", 15, "male", 6000));
        mockCompanies.add(new Company(123, "OOCL", employees, employees.size()));
        Mockito.when(mockCompanyRepository.getCompanies()).thenReturn(mockCompanies);

        mockMvc.perform(get("/companies/123/employees"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"id\":10002,\"name\":\"Test\",\"age\":15,\"gender\":\"male\"}]"));
    }



}