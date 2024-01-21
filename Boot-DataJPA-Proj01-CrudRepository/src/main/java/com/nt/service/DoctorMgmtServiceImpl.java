package com.nt.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.repository.IDoctorRepo;
import com.nt.sbeans.Doctor;

@Service("doctorService")
public class DoctorMgmtServiceImpl implements IDoctorService {

	@Autowired
	private IDoctorRepo doctorRepo;

	// Save single object(record)
	@Override
	public String registerDoctor(Doctor doctor) {
		System.out.println("doc id(before save:: " + doctor.getDocId());
		Doctor doc = doctorRepo.save(doctor);
		return "Doctor obj is saved with the id value :" + doc.getDocId();
	}

	// Save multiple object(record)

	/*@SuppressWarnings("unchecked")
	@Override
	public String registerGroupOfDoctors(Iterable<Doctor> doctors) {
	
		if (doctors != null) {
	
			Iterable<Doctor> savedDoctors = doctorRepo.saveAll(doctors);
			int size = ((Collection) savedDoctors).size();
			List<Integer> ids = (List<Integer>) ((Collection) savedDoctors).stream().map(d -> ((Doctor) d).getDocId())
					.collect(Collectors.toList());
	
			return size + " no.of doctors are saved with id values : " + ids.toString();
	
		} else
			throw new IllegalArgumentException("Invalid doctors info");
	
	}
	*/
	// OR
	@Override
	public String registerGroupOfDoctors(Iterable<Doctor> doctors) {

		if (doctors != null) {
			Iterable<Doctor> savedDoctors = doctorRepo.saveAll(doctors);
			int size = ((Collection) savedDoctors).size();

			List<Integer> ids = new ArrayList();
			savedDoctors.forEach(d -> {
				ids.add(d.getDocId());
			});
			return size + " no.doctors are saved with id values:  " + ids.toString();
		} else {
			throw new IllegalArgumentException("Invalid doctors information");

		}
	}

	// Count all object(record) from db
	@Override
	public long fetchDoctorsCount() {

		return doctorRepo.count();
	}

	// check object(record) from table by id

	@Override
	public boolean checkDoctorAvailability(Integer id) {

		return doctorRepo.existsById(id);
	}

	// gives all the records of the table in from of
	// iterable/List of entity class object using finAll() method

	@Override
	public Iterable<Doctor> showAllDoctors() {
		return doctorRepo.findAll();
	}

	// show all Doctors object by method
	// Iterable<Doctor> methodName(Iterable<Integer>ids);
	@Override
	public Iterable<Doctor> showAllDoctorsByIds(Iterable<Integer> ids) {
		return doctorRepo.findAllById(ids);
	}

	// show single object by id
	/*@Override
	public Doctor showDoctorById(Integer id) {
		Doctor dutyDoctor = new Doctor();
		Doctor doctor = doctorRepo.findById(id).orElse(dutyDoctor);
		return doctor;
	}*/

	// OR Best
	@Override
	public Doctor showDoctorById(Integer id) {
		Doctor doctor = doctorRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid doctor id"));
		return doctor;
	}

	// update Doctor(single object) by id
	@Override
	public String updateDoctorIncomeById(Integer id, float hikePercentage) {
		// load the object
		Optional<Doctor> opt = doctorRepo.findById(id);
		if (opt.isPresent()) {
			Doctor doctor = opt.get();
			double newIncome = doctor.getIncome() + (doctor.getIncome() * (hikePercentage / 100.0f));
			// set new income to Entity object
			doctor.setIncome(newIncome);
			// partially update the object
			return doctorRepo.save(doctor).getDocId() + " is updated with " + newIncome;
		} else {
			return id + " doctor not found";

		}

	}
	// update or Insert operation

	@Override
	public String registerOrUpdateDoctor(Doctor doctor) {

		// load Doctor class object
		Optional<Doctor> opt = doctorRepo.findById(doctor.getDocId());
		if (opt.isPresent()) {
			doctorRepo.save(doctor); // for update operation
			return doctor.getDocId() + " Doctor details are found and updated";

		} else {
			return "Docotor is saved with id value: " + doctorRepo.save(doctor).getDocId();
		}

	}

	// delete single object by id

	@Override
	public String deleteDoctorById(Integer id) {
		// load the object
		Optional<Doctor> opt1 = doctorRepo.findById(id);
		if (opt1.isPresent()) {
			doctorRepo.deleteById(id);
			return id + " doctor is deleted";
		} else {
			return id + " doctor not found for deletion";
		}
	}
	// delete single object throw Entity class and using id

	@Override
	public String deleteDoctor(Doctor doctor) {
		// load the object
		Optional<Doctor> opt2 = doctorRepo.findById(doctor.getDocId());
		if (opt2.isPresent()) {
			// doctorRepo.delete(opt2.get());
			doctorRepo.delete(doctor);
			return doctor.getDocId() + " doctor found and deleted";
		} else {
			return doctor.getDocId() + " doctor is not found";
		}
	}

	// remove all object form the DB
	@Override
	public String removeAllDoctors() {
		long count = doctorRepo.count();
		if (count > 0) {
			doctorRepo.deleteAll();
			return count + " no.of records are deleted";
		} else {
			return "no recored are found for deletion";
		}

	}

	// remove object by id(multiple ids)
	@Override
	public String removeDoctorsById(List<Integer> ids) {

		List<Doctor> docsList = (List<Doctor>) doctorRepo.findAll();
		if (docsList.size() == ids.size()) {
			doctorRepo.deleteAllById(ids);
			return docsList.size() + " no.of records are deleted";
		} else
			return "some of given id values records are not found in to the table";
	}

	}
