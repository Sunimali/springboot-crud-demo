package com.turan.springboot.springbootcruddemo.rest;

import com.turan.springboot.springbootcruddemo.dao.EmployeeDAO;

import com.turan.springboot.springbootcruddemo.entity.Employee;
import com.turan.springboot.springbootcruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    // inject employee DAO (constructor injection)
    @Autowired
    public EmployeeRestController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    // expose "employees" and return list of employees
    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return employeeService.findAll();
    }

    // expose "employees/{employeeId}" and return an employee by Id
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId){
        Employee employee = employeeService.findById(employeeId);

        if(employee == null){
            throw new RuntimeException("Employee with the id " + employeeId + "not found !");
        }

        return employee;
    }

    // expose "employees" and inserts an employee
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        employee.setId(0);

        employeeService.saveEmployee(employee);

        return employee;
    }

    // expose "employees" and updates an employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody  Employee employee){
        employeeService.saveEmployee(employee);

        return employee;
    }

    // expose "employees/{employeeId}" and delete an employee
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){

        Employee employee = employeeService.findById(employeeId);

        if(employee == null){
            throw new RuntimeException("Employee with the id " + employeeId + "not found !");
        }
        employeeService.deleteById(employeeId);

        return "Deleted employe is " + employeeId;
    }
}
