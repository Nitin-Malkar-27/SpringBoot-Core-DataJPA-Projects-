package com.nt.service;

import java.util.List;

import com.nt.entity.Doctor;

public interface IDoctorMgmtService {
	public String deleteDoctorByIdsInBatch(List<Integer> ids);

	public List<Doctor> showDoctorsByExampleData(Doctor exDoctor, boolean ascOrder, String... properties);

	public Doctor findDoctorById(Integer id);
}
