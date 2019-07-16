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
public class EmployeeControllerTest {

//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private EmployeeRepository mockEmployeeRepository;
//
//    @Test
//    public void should_return_employees_when_request_all_employees_api() throws Exception {
//        List<Employee> mockEmployeeList = new ArrayList<>();
//        mockEmployeeList.add(new Employee(10001, "Test", 15, "male", 6000));
//        Mockito.when(mockEmployeeRepository.getEmployees()).thenReturn(mockEmployeeList);
//
//        mockMvc.perform(get("/employees"))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(content().json("[{\"id\":10001,\"name\":\"Test\",\"age\":15,\"gender\":\"male\"}]"));
//    }

//    @Test
//    public void should_return_employee_whose_id_is_1_when_request_all_employees_api() throws Exception {
//        List<Employee> mockEmployeeList = new ArrayList<>();
//        mockEmployeeList.add(new Employee(10001, "Test", 15, "male", 6000));
//        Mockito.when(mockEmployeeRepository.getEmployees()).thenReturn(mockEmployeeList);
//
//        mockMvc.perform(get("/employees"))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(content().json("[{\"id\":10001,\"name\":\"Test\",\"age\":15,\"gender\":\"male\"}]"));
//    }
}