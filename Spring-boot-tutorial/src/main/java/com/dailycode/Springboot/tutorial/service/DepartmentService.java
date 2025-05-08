package com.dailycode.Springboot.tutorial.service;

import com.dailycode.Springboot.tutorial.entity.Department;
import com.dailycode.Springboot.tutorial.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {



  public List<Department> fechDepartmentList();

 public    Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

  public  void deleteDepartmentById(Long departmentId);


 public  Department updateDepartment(Long departmentId, Department department);

   public Department saveDepartment(Department department);


  public  Department fetchDepartmentByName(String departmentName);
}
