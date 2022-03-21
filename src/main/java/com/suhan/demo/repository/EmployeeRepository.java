package com.suhan.demo.repository;

import com.suhan.demo.models.Employee;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee, String> {

}