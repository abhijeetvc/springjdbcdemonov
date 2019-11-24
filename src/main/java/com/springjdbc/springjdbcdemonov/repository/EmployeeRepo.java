package com.springjdbc.springjdbcdemonov.repository;

import com.springjdbc.springjdbcdemonov.model.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeRepo {

    List<Employee> getEmployeeList();

    Employee getEmployee(Integer id);

    String saveEmp(Employee employee);

    List<Map<String,Object>> getCombinedData();
}
