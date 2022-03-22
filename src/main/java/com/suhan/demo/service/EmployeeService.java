package com.suhan.demo.service;

import java.util.List;

import com.suhan.demo.models.Employee;
import com.suhan.demo.repository.EmployeeRepository;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> createEmployees(List<Employee> employees) {
        return employeeRepository.saveAll(employees);
    }

    public List<Employee> getAllEmployeeInfo() {
        return employeeRepository.findAll();
    }

    public List<Employee> getEmployee(String name) {
        return employeeRepository.findBy(name);
    }

}
