package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nt.entity.Employee;
import com.nt.repository.IEmployeeRepo;

@Service("empService")
public class EmployeeMgmtService implements IEmployeeMgmtService {

	@Autowired
	private IEmployeeRepo empRepo;

	@Override
	public String saveEmployee(Employee e) {

		return "MongoDB doc is saved with id vaalue :" + empRepo.insert(e).getId();

	}

	@Override
	public List<Employee> showAllEmployees() {
		return empRepo.findAll();
	}

	@Override
	public String searchEmployeeById(String idVal) {
		Optional<Employee> opt = empRepo.findById(idVal);
		if (opt.isPresent()) {
			return opt.get().toString();
		} else {
			return "Document no found";
		}
	}

	@Override
	public String modifyEmployeeById(String idVal, Double newSal) {

		Optional<Employee> opt = empRepo.findById(idVal);
		if (opt.isEmpty()) {
			return "Documnet is not found";
		} else {

			Employee emp = opt.get();
			emp.setSalary(newSal);
			empRepo.save(emp);
			return "Document found and updated of id :" + idVal;
		}
	}

	@Override
	public String removeEmployeeById(String idVal) {
		Optional<Employee> opt = empRepo.findById(idVal);
		if (opt.isEmpty()) {
			return "Document no found";
		} else {
			empRepo.deleteById(idVal);
			return "Document found and deleted";
		}
	}

	@Override
	public List<Employee> showAllEmplyeesBySort(Boolean asc, String... properties) {

		// creat the sort object
		Sort sort = Sort.by(asc ? Direction.ASC : Direction.DESC, properties);
		// get the docs by sorting
		List<Employee> list = empRepo.findAll(sort);
		return list;
	}

	@Override
	public List<Employee> searchEmployeesByExampleData(Employee emp, boolean asc, String... props) {
		// Example object
		Example<Employee> example = Example.of(emp);
		Sort sort = Sort.by(asc ? Direction.ASC : Direction.DESC, props);
		List<Employee> list = empRepo.findAll(example, sort);
		return list;
	}

	@Override
	public String registerEmployee(Employee emp) {

		return "MongoDb Doc is saved with the id value: " + empRepo.insert(emp).getId();
	}

}
