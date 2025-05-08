package com.dailycode.Springboot.tutorial.repository;

import com.dailycode.Springboot.tutorial.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
    public Department findBydepartmentName(String departmentName);
     public Department findByDepartmentNameIgnoreCase(String departmentName);
}
