package com.nt.service;

import java.util.List;

import com.nt.entity.Employee_info;

public interface IEmployeeMgmtService {

	public List<Employee_info> showEmployeeBySalaryRange(double start, double end);

}
