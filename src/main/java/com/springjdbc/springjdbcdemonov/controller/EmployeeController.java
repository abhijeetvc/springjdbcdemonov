package com.springjdbc.springjdbcdemonov.controller;

import com.springjdbc.springjdbcdemonov.model.Employee;
import com.springjdbc.springjdbcdemonov.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @PostMapping(value="/saveemp")
    public String saveEmployee(@RequestBody Employee employee){
        String str=employeeRepo.saveEmp(employee);
        return str;
    }

    @GetMapping(value="/getJoindata")
    public List<Map<String,Object>> getCombinedData(){
        List<Map<String,Object>> list=employeeRepo.getCombinedData();
        return list;
    }
}
