package com.springjdbc.springjdbcdemonov.controller;

import com.springjdbc.springjdbcdemonov.model.Employee;
import com.springjdbc.springjdbcdemonov.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepo employeeRepo;

    @GetMapping(value="/getemp")
    public List<Employee> getList(){
        return employeeRepo.getEmployeeList();
    }

    @GetMapping(value="/getempbyid/{id}")
    public Employee getEmp(@PathVariable Integer id){
        return employeeRepo.getEmployee(id);
    }
}
