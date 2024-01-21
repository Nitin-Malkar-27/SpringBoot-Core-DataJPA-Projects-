package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nt.entity.Doctor;
import com.nt.repository.IDoctorRepository;

@Service
public class DoctorMgmtServcieImpl implements IDoctorMgmtService {

	@Autowired
	private IDoctorRepository doctorRepo;

	// delete doctor by id though batch
	@Override
	public String deleteDoctorByIdsInBatch(List<Integer> ids) {
		// load the entities
		List<Doctor> list = doctorRepo.findAllById(ids);

		if (list.size() != 0) {
			// delete the entities
			doctorRepo.deleteAllByIdInBatch(ids);
			return list.size() + " recored are deleted";
		} else {
			return "recoreds not found for deletion";
		}
	}

	// show doctor by Example class object
	@Override
	public List<Doctor> showDoctorsByExampleData(Doctor exDoctor, boolean ascOrder, String... properties) {

		// prepare Sort object
		Sort sort = Sort.by(ascOrder ? Direction.ASC : Direction.DESC, properties);
		// Example class object
		Example example = Example.of(exDoctor);
		// use the repo
		List<Doctor> list = doctorRepo.findAll(example, sort);
		return list;
	}

	// find doctor by getReferenceById() method

	@Override
	public Doctor findDoctorById(Integer id) {

		 Doctor doctor = doctorRepo.getById(id);
		//Doctor doctor = doctorRepo.getReferenceById(id);
		return doctor;
	}

}
