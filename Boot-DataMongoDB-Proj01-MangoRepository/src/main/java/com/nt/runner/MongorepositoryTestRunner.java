package com.nt.runner;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Employee;
import com.nt.service.IEmployeeMgmtService;

@Component
public class MongorepositoryTestRunner implements CommandLineRunner {

	@Autowired
	private IEmployeeMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		Employee e = new Employee();
		e.setEno(105);
		e.setEname("rajesh");
		e.setEadd("pune");
		e.setSalary(230000.0);
		e.setIsVaccinated(true);
		// System.out.println(service.saveEmployee(e));

		System.out.println("--------------------------------------");
		service.showAllEmployees().forEach(System.out::println);

		System.out.println("-----------------------------------------");
		System.out.println("Doc info: " + service.searchEmployeeById("64e2198b721d58601ab4e020"));

		System.out.println("----------------------------------------------");
		System.out.println(service.modifyEmployeeById("64e2198b721d58601ab4e020", 12000.0));

		System.out.println("-----------delete by id-----------------------");
		System.out.println(service.removeEmployeeById("64e2198b721d58601ab4e020"));

		System.out.println("--------show all Emplyees by sort--------------");
		service.showAllEmplyeesBySort(true, "ename").forEach(System.out::println);

		System.out.println("--Getting docs based on Example documet obj by appling sorting----");

		try {
			Employee emp = new Employee();
			emp.setSalary(230000.0);
			emp.setEadd("pune");
			service.searchEmployeesByExampleData(emp, true, "ename").forEach(System.out::println);

		} catch (Exception ee) {
			ee.printStackTrace();
		}
		System.out.println("---  use Random UUID base ID----------");
		Employee e1 = new Employee();
		e1.setId(UUID.randomUUID().toString());
		e1.setEno(123);
		e1.setEadd("mukesh");
		e1.setEadd("mum");
		e1.setSalary(500000.0);
		e1.setIsVaccinated(false);
		System.out.println(service.registerEmployee(e1));
	}

}
