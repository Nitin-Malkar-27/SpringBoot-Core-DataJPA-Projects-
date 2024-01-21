package com.nt.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nt.entity.Employee;

public interface IEmployeeRepo extends MongoRepository<Employee, String> {

}
