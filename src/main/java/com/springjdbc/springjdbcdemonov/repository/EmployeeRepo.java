package com.springjdbc.springjdbcdemonov.repository;

import com.springjdbc.springjdbcdemonov.model.Employee;

import java.util.List;

public interface EmployeeRepo {

    List<Employee> getEmployeeList();

    Employee getEmployee(Integer id);
}
