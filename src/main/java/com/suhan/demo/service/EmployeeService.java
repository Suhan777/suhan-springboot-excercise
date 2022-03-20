package com.suhan.demo.service;

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
}
