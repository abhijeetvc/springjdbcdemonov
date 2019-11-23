package com.springjdbc.springjdbcdemonov.dao;

import com.springjdbc.springjdbcdemonov.model.Employee;
import com.springjdbc.springjdbcdemonov.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDao implements EmployeeRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Employee> getEmployeeList() {
        String sql="select name,city from employee";
        List<Employee> list=
                jdbcTemplate.query(sql,
                        new BeanPropertyRowMapper<>(Employee.class));
        return list;
    }

    @Override
    public Employee getEmployee(Integer id) {

        String sql="select * from employee where id=?";
        Employee e=jdbcTemplate.queryForObject(sql,
                new Object[]{id},
                new BeanPropertyRowMapper<>(Employee.class));
        return e;
    }
}
