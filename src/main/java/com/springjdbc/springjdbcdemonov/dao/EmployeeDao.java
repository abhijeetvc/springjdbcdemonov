package com.springjdbc.springjdbcdemonov.dao;

import com.springjdbc.springjdbcdemonov.model.Employee;
import com.springjdbc.springjdbcdemonov.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.List;
import java.util.Map;

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

    @Override
    public String saveEmp(Employee employee) {

        String sql="insert into employee values(?,?,?)";
        jdbcTemplate.update(sql,new Object[]{employee.getId(),employee.getName(),employee.getCity()});
        return "Employee saved";
    }

    @Override
    public List<Map<String, Object>> getCombinedData() {

        String sql="select a.id,a.name,a.city,b.name as deptName from employee a,department b where b.id=a.dept_id";

        List<Map<String,Object>> list=jdbcTemplate.queryForList(sql);
        return list;
    }
}



