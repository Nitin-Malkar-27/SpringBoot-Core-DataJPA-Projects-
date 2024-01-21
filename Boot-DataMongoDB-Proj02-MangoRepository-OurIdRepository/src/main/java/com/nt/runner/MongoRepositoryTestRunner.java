package com.nt.runner;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.document.Employee;
import com.nt.service.IEmployeeMgmtService;

@Component("testRunner")
public class MongoRepositoryTestRunner implements CommandLineRunner {

	@Autowired
	private IEmployeeMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		// create the Document object
		Employee e = new Employee();
		e.setEno(new Random().nextInt(10000));
		e.setEname("komal");
		e.setEadd("pune");
		e.setIsVaccinated(true);
		e.setEmail("rajesh@gmail.com");
		e.setSalary(43000.0);

		// System.out.println(service.registerEmployee(e));

		System.out.println("--------show emp byId----------");
		Optional<Employee> opt = service.showEmployeeById(4940);
		if (opt.isPresent()) {
			System.out.println("Employee details:: " + opt.get());
		} else {
			System.out.println("Employee is not found");
		}

		System.out.println("----find emp id by salary range-----");
		service.searchEmployeeBySalaryRange(10000, 90000).forEach(System.out::println);

		System.out.println("-------------emp find by email------------");

		System.out.println("employee info:: " + service.searchEmployeeByEmail("rajesh@gmail.com"));
	}

}
