package com.suhan.demo.repository;

import java.util.List;

import com.suhan.demo.models.Employee;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface EmployeeRepository extends MongoRepository<Employee, String> {

    @Query("{'FirstName': ?0}")
    public List<Employee> findBy(String FirstName);

    public void insert(Employee[] employees);
}