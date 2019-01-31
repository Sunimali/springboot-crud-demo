package com.turan.springboot.springbootcruddemo.dao;

import com.turan.springboot.springbootcruddemo.entity.Employee;
import java.util.List;

public interface EmployeeDAO {

    public List<Employee> findAll();

    public Employee findById(int id);

    public void saveEmployee(Employee employee);

    public void deleteById(int id);
}