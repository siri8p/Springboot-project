package com.dailycode.Springboot.tutorial.service;

import com.dailycode.Springboot.tutorial.entity.Department;
import com.dailycode.Springboot.tutorial.error.DepartmentNotFoundException;
import com.dailycode.Springboot.tutorial.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;


    @Override
    public List<Department> fechDepartmentList() {
        return  departmentRepository.findAll();
    }

    @Override
    public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException {
       // return  departmentRepository.findById(departmentId).get();
        Optional<Department> department = departmentRepository.findById(departmentId);
        if(!department.isPresent()){
            throw  new DepartmentNotFoundException("Department not available");
        }
         return  department.get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
         departmentRepository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartment(Long departmentId, Department department) {
      Department depdb= departmentRepository.findById(departmentId).get();
      if(Objects.nonNull(department.getDepartmentName()) &&
              !" ".equalsIgnoreCase(department.getDepartmentName())){
          depdb.setDepartmentName((department.getDepartmentName()));
      }
        if(Objects.nonNull(department.getDepartmentCode()) &&
                !" ".equalsIgnoreCase(department.getDepartmentCode())){
            depdb.setDepartmentName((department.getDepartmentCode()));
        }
        if(Objects.nonNull(department.getDepartmentAddress()) &&
                !" ".equalsIgnoreCase(department.getDepartmentAddress())){
            depdb.setDepartmentName((department.getDepartmentAddress()));
        }

                   return departmentRepository.save(depdb);


    }

    @Override
    public Department saveDepartment(Department department) {
        return  departmentRepository.save(department) ;
    }

//    @Override
//    public Department fetchDepartmentByName(String departmentName) {
//        return  departmentRepository. findBydepartmentName(departmentName);
//
//    }
    @Override
    public Department fetchDepartmentByName(String departmentName) {
        return  departmentRepository. findByDepartmentNameIgnoreCase(departmentName);

    }
}
