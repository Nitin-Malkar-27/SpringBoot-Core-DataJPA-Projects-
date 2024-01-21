package com.nt.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nt.document.Employee;

public interface IEmployeeRepository extends MongoRepository<Employee, Integer> {

	public List<Employee> findBySalaryBetween(double start, double end);

	public Employee findByEmail(String email);
}
