package com.turan.springboot.springbootcruddemo.dao;

import com.turan.springboot.springbootcruddemo.entity.Employee;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import org.hibernate.query.Query;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    // define field for entity manager
    private EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // create the query
        Query<Employee> query = currentSession.createQuery("from Employee", Employee.class);

        // execute query and get the result list
        List<Employee> employees = query.getResultList();

        // return the list
        return employees;
    }

    @Override
    public Employee findById(int id) {
        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // get the employee
        Employee employee = currentSession.get(Employee.class, id);

        // return the employee
        return employee;
    }

    @Override
    public void saveEmployee(Employee employee) {
        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // save the employee
        currentSession.saveOrUpdate(employee);
    }

    @Override
    public void deleteById(int id) {
        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // create the query
        Query<Employee> query = currentSession.createQuery("delete from Employee where id=:employeeId");
        query.setParameter("employeeId" ,id);

        query.executeUpdate();
    }
}
