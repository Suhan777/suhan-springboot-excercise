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

@RestController
@RequestMapping("/employeeInfo")
public class EmployeeController {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Employee> getAllEmployeeInfo() {
        logger.info("Getting All Employee info");
        List<Employee> employeeInfo = employeeService.getAllEmployeeInfo();
        logger.info("Employees info: {}", Arrays.toString(employeeInfo.toArray()));
        return employeeInfo;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{employeeName}")
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
