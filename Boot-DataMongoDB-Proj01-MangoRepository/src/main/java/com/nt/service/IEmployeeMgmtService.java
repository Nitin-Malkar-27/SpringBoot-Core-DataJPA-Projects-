package com.nt.service;

import java.util.List;

import com.nt.entity.Employee;

public interface IEmployeeMgmtService {
	public String saveEmployee(Employee e);

	public List<Employee> showAllEmployees();

	public String searchEmployeeById(String idVal);

	public String modifyEmployeeById(String idVal, Double newSal);

	public String removeEmployeeById(String idVal);

	public List<Employee> showAllEmplyeesBySort(Boolean asc, String... properties);

	public List<Employee> searchEmployeesByExampleData(Employee emp, boolean asc, String... props);

	public String registerEmployee(Employee emp);
}
