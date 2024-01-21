package com.nt.runners;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.IDoctorMgmtService;

@Component
public class JpaRepoTestRunner implements CommandLineRunner {

	@Autowired
	private IDoctorMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		// delete doctors by batch
		// System.out.println(service.deleteDoctorByIdsInBatch(List.of(15, null)));//
		// this null show the
		// NullPointerException

		System.out.println(service.deleteDoctorByIdsInBatch(Arrays.asList(15, 20, null)));
		/*
				// show doctor by findAll() using Example class
				Doctor doctor = new Doctor();
				doctor.setSpecialization("cardio");
				//doctor.setIncome(45000.0);
				service.showDoctorsByExampleData(doctor, true, "income").forEach(System.out::println);*/

		
		//find doctor getById() or getReferenceById
		System.out.println(service.findDoctorById(21));
	}

}
