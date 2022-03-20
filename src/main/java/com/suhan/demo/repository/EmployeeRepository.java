
package com.suhan.demo.repository;

import java.util.List;

import com.suhan.demo.models.Employee;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface EmployeeRepository extends MongoRepository<Employee, String> {

    @Query("{name:'?0'}")
    Employee findItemByName(String name);

    @Query(value = "{category:'?0'}", fields = "{'name' : 1, 'quantity' : 1}")
    List<Employee> findAll(String category);

    public long count();

}