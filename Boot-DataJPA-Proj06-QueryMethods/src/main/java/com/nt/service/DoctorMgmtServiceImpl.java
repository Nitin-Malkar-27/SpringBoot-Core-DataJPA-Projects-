package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Doctor;
import com.nt.repository.IDoctorRepository;

@Service
public class DoctorMgmtServiceImpl implements IDoctorMgmtService {

	@Autowired
	private IDoctorRepository doctorRepo;

	@Override
	public List<Doctor> showDoctorsByIncomeRange(double startRange, double endRange) {

		return doctorRepo.searchDoctorsByIncomeRange(startRange, endRange);
	}

	@Override
	public List<Doctor> searchDoctorBySpecialization(String sp1, String sp2) {

		// user repo
		List<Doctor> list = doctorRepo.searchDoctorBySpecialization(sp1, sp2);

		return list;
	}

	@Override
	public List<Object[]> showDoctorsDataByIncome(double start, double end) {
		// use doc repo
		List<Object[]> list = doctorRepo.searchDoctorDataByIncome(start, end);
		return list;
	}

	@Override
	public List<String> showDoctorsDataByIncomeRange(double min, double max) {

		List<String> list = doctorRepo.searchAllDoctorNamesByIncomeRange(min, max);
		return list;
	}

	@Override
	public Doctor searchDoctorByNameDocName(String docName) {
		Doctor doc = doctorRepo.showDoctorInfoByName(docName)
				.orElseThrow(() -> new IllegalArgumentException("Doctor not found..."));
		return doc;
	}

	@Override
	public Object searchDoctorDataByName(String docName) {
		Object obj = doctorRepo.showDoctorDataByName(docName);
		return obj;
	}

	@Override
	public String searchSpecializationByName(String docName) {

		String result = doctorRepo.showSpecializationByName(docName);
		return result;
	}

	@Override
	public int showDoctorNamesCount() {
		return doctorRepo.fetchDoctorsNameCount();
	}

	public Object showAggregateData() {
		Object obj = doctorRepo.fetchAggregateData();
		return obj;
	}

	@Override
	public int appraiseDoctorsIncomeBySpecialization(String specialization, double hikePercentage) {

		int count = doctorRepo.hikeDoctorsIncomeBySpecialization(specialization, hikePercentage);
		return count;
	}

	@Override
	public int fireDoctorsByIncomeRange(double start, double end) {
		return doctorRepo.removeDoctorsByIncomeRange(start, end);
	}

	@Override
	public String insertDoctor(String name, double income, String specialization) {
		int count = doctorRepo.registerDoctor(name, specialization, income);

		return count == 0 ? " Doctro not registered" : "Doctor is registered";
	}

	@Override
	public String showSystemDate() {
		return doctorRepo.showSystemDate();
	}

	@Override
	public String createTempDBTable() {
		int count = doctorRepo.createTempTable();
		return count == 0 ? "db table is created" : "table is not created";
	}

}
