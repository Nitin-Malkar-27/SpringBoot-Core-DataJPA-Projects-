package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.document.Employee;
import com.nt.repository.IEmployeeRepository;

@Service("empService")
public class EmployeeMgmtSerrviceImpl implements IEmployeeMgmtService {

	@Autowired
	private IEmployeeRepository empRepo;

	@Override
	public String registerEmployee(Employee e) {
		return "MongoDb Doc is saved with id value:: " + empRepo.insert(e).getEno();

	}

	@Override
	public Optional<Employee> showEmployeeById(int id) {

		return empRepo.findById(id);
	}

	@Override
	public List<Employee> searchEmployeeBySalaryRange(double start, double end) {
		List<Employee> list = empRepo.findBySalaryBetween(start, end);
		return list;
	}

	@Override
	public Employee searchEmployeeByEmail(String email) {

		return empRepo.findByEmail(email);
	}

}
