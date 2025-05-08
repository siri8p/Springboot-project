package com.dailycode.Springboot.tutorial.service;

import com.dailycode.Springboot.tutorial.entity.Department;
import com.dailycode.Springboot.tutorial.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DepartmentServiceTest {
    @Autowired
    private DepartmentService  departmentService;
    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department =
                Department.builder()
                        .departmentId(1L)
                        .departmentName("IT")
                        .build();
        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT"))
                .thenReturn(department);
    }
    @Test
    @DisplayName("get data based on valid department name")
    public void whenValidDepartmentName_thenDepartmentShouldFound(){
        String departmentName ="IT";
        Department found= departmentService.fetchDepartmentByName(departmentName);
        assertEquals(departmentName, found.getDepartmentName());

    }


}