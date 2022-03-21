package com.suhan.demo.service;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import com.suhan.demo.models.Employee;
import com.suhan.demo.repository.EmployeeRepository;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void createEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployeeInfo() {
        return employeeRepository.findAll();
    }

    public List<Employee> getEmployee(String name) {
        return employeeRepository.findBy(name);
    }

}
