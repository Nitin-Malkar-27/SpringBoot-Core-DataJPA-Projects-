package com.nt.service;

import java.util.List;
import java.util.Optional;

import com.nt.document.Employee;

public interface IEmployeeMgmtService {

	public String registerEmployee(Employee e);

	public Optional<Employee> showEmployeeById(int id);

	public List<Employee> searchEmployeeBySalaryRange(double start, double end);

	public Employee searchEmployeeByEmail(String email);
}
