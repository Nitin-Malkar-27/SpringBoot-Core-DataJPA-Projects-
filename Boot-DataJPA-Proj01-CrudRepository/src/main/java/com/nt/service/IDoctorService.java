package com.nt.service;

import java.util.List;

import com.nt.sbeans.Doctor;

public interface IDoctorService {
	public String registerDoctor(Doctor doctors);

	public String registerGroupOfDoctors(Iterable<Doctor> doctor);

	public long fetchDoctorsCount();

	public boolean checkDoctorAvailability(Integer id);

	public Iterable<Doctor> showAllDoctors();

	public Iterable<Doctor> showAllDoctorsByIds(Iterable<Integer> ids);

	public Doctor showDoctorById(Integer id);

	public String updateDoctorIncomeById(Integer id, float hikePercentage);

	public String registerOrUpdateDoctor(Doctor doctor);

	public String deleteDoctorById(Integer id);

	public String deleteDoctor(Doctor doctor);

	public String removeAllDoctors();

	public String removeDoctorsById(List<Integer> ids);

	//public String deleteAllDoc(Iterable<Doctor> doc3);
}
