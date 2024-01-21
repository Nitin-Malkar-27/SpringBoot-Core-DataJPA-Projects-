//EmployeeMgmtServiceImpl.java
package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.IEmployeeDAO;
import com.nt.model.Employee;

@Service("empService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {

	public EmployeeMgmtServiceImpl() {
		System.out.println("EmployeeMgmtServiceImpl:: 0-param constructor");
	}

	@Autowired
	private IEmployeeDAO empDAO;

	@Override
	public String registerEmployee(Employee emp) throws Exception {
		// calcaute gross salary and netsalary
		double grossSalary = emp.getSalary() + (emp.getSalary() * 0.4f);
		double netSaalary = grossSalary - (grossSalary * 0.2f);
		// set gross salary, netSalary to Employee class object
		emp.setGrossSalary(grossSalary);
		emp.setNetSalary(netSaalary);
		// use DAO
		int count = empDAO.insert(emp);

		return count == 0 ? " Employee registration failed"
				: "Employee registered and the salary==" + emp.getSalary() + "---grossSalary==" + emp.getGrossSalary()
						+ "---NetSaslary==" + emp.getNetSalary();
	}

}
