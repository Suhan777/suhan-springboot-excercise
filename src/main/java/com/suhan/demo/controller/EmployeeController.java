package com.suhan.demo.controller;

import java.util.Arrays;
import java.util.List;

import com.suhan.demo.models.Employee;
import com.suhan.demo.service.EmployeeService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/employeeInfo")
public class EmployeeController {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addEmployee")
    public Employee newEmployee(@RequestBody Employee newEmployee) {
        logger.info("Adding Employee {}", newEmployee);
        try {
            return employeeService.createEmployee(newEmployee);
        } catch (Exception e) {
            logger.error("Error while adding employee {}", newEmployee);
            return null;
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addEmployees")
    public List<Employee> newEmployees(@RequestBody List<Employee> newEmployees) {
        logger.info("Adding Employee {}", newEmployees);
        try {
            return employeeService.createEmployees(newEmployees);
        } catch (Exception e) {
            logger.error("Error while adding employee {}", newEmployees);
            return null;
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public Object getAllEmployeeInfo() {
        logger.info("Getting All Employee info");
        List<Employee> employeeInfo = employeeService.getAllEmployeeInfo();
        logger.info("Employees info: {}", Arrays.toString(employeeInfo.toArray()));
        if (employeeInfo.size() > 0) {
            logger.info("Employee info: {}", Arrays.toString((employeeInfo).toArray()));
            return employeeInfo;
        } else {
            logger.info("No employees listed");
            return "No employees listed";
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{employeeSurname}")
    public Object getEmployee(@PathVariable String employeeName) {
        logger.info("Getting " + employeeName + " employee info");
        List<Employee> employee = employeeService.getEmployee(employeeName);
        if (employee.size() > 0) {
            logger.info("Employee info: {}", Arrays.toString((employee).toArray()));
            return employee;
        } else {
            logger.info("Employee not found");
            return "Employee not found";
        }
    }

}
