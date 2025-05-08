package com.dailycode.Springboot.tutorial.controller;

import com.dailycode.Springboot.tutorial.entity.Department;
import com.dailycode.Springboot.tutorial.error.DepartmentNotFoundException;
import com.dailycode.Springboot.tutorial.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department) {
        LOGGER.info("inside saveDeparmtnet of");
        return departmentService.saveDepartment(department);

    }
    @GetMapping("/departments")
    public List<Department> fechDepartmentList(){
        LOGGER.info("inside  fechdepartmentlist of");
        return  departmentService.fechDepartmentList();

    }
    @GetMapping("/departments/{id}")
    public  Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
           LOGGER.info("inside fetch department of");
           return departmentService.fetchDepartmentById(departmentId);
    }
    @DeleteMapping("/departments/{id}")
    public  String deleteDepartmentByid(@PathVariable("id")Long departmentId){
               departmentService.deleteDepartmentById(departmentId);
               return "department deleted successfully";
    }
    @PutMapping("/departments/{id}")
    public  Department updateDepartment(@PathVariable("id") Long departmentId,
                                        @RequestBody Department department){
         return departmentService.updateDepartment(departmentId,department);
    }
    @GetMapping("/departments/name/{name}")
        public Department  fetchDepartmentByName(@PathVariable("name")String departmentName){
          return departmentService.fetchDepartmentByName(departmentName);


        }

}
