package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Employee_info;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;

@Service("doctorService")
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService {

	@Autowired
	private EntityManager manager;

	@Override
	public List<Employee_info> showEmployeeBySalaryRange(double start, double end) {

		// create StoredProcedureQuery object pointing PL/SQL procedure
		StoredProcedureQuery query = manager.createStoredProcedureQuery("p_emp_details_by_salaryRange",
				Employee_info.class);
		// registred both IN,OUT params by specifying their mode
		query.registerStoredProcedureParameter(1, Double.class, ParameterMode.IN);
		query.registerStoredProcedureParameter(2, Double.class, ParameterMode.IN);

		// set the values to IN params
		query.setParameter(1, start);
		query.setParameter(2, end);

		// call the PL/SQL procedure
		List<Employee_info> list = query.getResultList();

		return list;
	}

}
