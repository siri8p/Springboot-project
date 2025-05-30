package com.dailycode.Springboot.tutorial.controller;

import com.dailycode.Springboot.tutorial.entity.Department;
import com.dailycode.Springboot.tutorial.error.DepartmentNotFoundException;
import com.dailycode.Springboot.tutorial.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.assertj.MockMvcTester;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {
    @Autowired
    private MockMvc  mockMvc;
    @MockBean
    private DepartmentService departmentService;
     private Department department;

    @BeforeEach
    void setUp() {

        department = Department.builder()
                .departmentAddress("nellore")
                .departmentCode("111")
                .departmentName("IT")
                .departmentId(1L)
                .build();
    }

    @Test
    void saveDepartment() throws Exception {
        Department inputDepartment = Department.builder()
                .departmentAddress("nellore")
                .departmentCode("111")
                .departmentName("IT")
                .build();
        Mockito.when(departmentService.saveDepartment(inputDepartment))
                .thenReturn(department);
        mockMvc.perform(post("/departments")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "\t\"departmentName\": \"IT\",\n" +
                        "\t\"departmentAddress\":\"nellore\",\n" +
                        "\t\"departmentCode\": \"111\"\n" +
                        "} "))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }




    @Test
    void fetchDepartmentById() throws Exception {
        Mockito.when(departmentService.fetchDepartmentById(1L))
           .thenReturn(department);

            mockMvc.perform(get("/departments/1")
                 .contentType(MediaType.APPLICATION_JSON))
                 .andExpect(status().isOk())
                 .andExpect(jsonPath("$.departmentName").
                          value(department.getDepartmentName()));

    }
}