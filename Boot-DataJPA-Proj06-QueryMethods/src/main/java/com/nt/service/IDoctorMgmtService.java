package com.nt.service;

import java.util.List;

import com.nt.entity.Doctor;

public interface IDoctorMgmtService {

	public List<Doctor> showDoctorsByIncomeRange(double startRange, double endRange);

	public List<Doctor> searchDoctorBySpecialization(String sp1, String sp2);

	public List<Object[]> showDoctorsDataByIncome(double start, double end);

	public List<String> showDoctorsDataByIncomeRange(double min, double max);

	public Doctor searchDoctorByNameDocName(String docName);

	public Object searchDoctorDataByName(String docName);

	public String searchSpecializationByName(String docName);

	public int showDoctorNamesCount();

	public Object showAggregateData();

	public int appraiseDoctorsIncomeBySpecialization(String specialization, double hikePercentage);

	public int fireDoctorsByIncomeRange(double start, double end);

	public String insertDoctor(String name, double income, String specialization);

	public String showSystemDate();

	public String createTempDBTable();
}
