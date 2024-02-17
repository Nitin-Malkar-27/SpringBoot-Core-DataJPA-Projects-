package com.nt;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.sbeans.Doctor;
import com.nt.service.IDoctorService;

@SpringBootApplication
public class BootDataJpaProj1CrudRepositoryApplication {

	public static void main(String[] args) {
		// get the IOC container

		ApplicationContext ctx = SpringApplication.run(BootDataJpaProj1CrudRepositoryApplication.class, args);

		// get the service class object
		IDoctorService service = ctx.getBean("doctorService", IDoctorService.class);

		// Save single object(record)
		/*try {
			// get the Doctor class object
			Doctor doctor = new Doctor();
			doctor.setDocName("Krushna");
			doctor.setSpecialization("MD-Medicine");
			doctor.setIncome(8900000.00);
		
			// invoke the business method
			String resultMsg = service.registerDoctor(doctor);
			System.out.println(resultMsg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/

		/*// Save multiple object(record)
		try {
			Doctor doc1 = new Doctor();
			doc1.setDocName("rajesh1");
			doc1.setIncome(45000.0);
			doc1.setSpecialization("Cardi");
		
			Doctor doc2 = new Doctor();
		
			doc2.setDocName("Mrunal");
			doc2.setIncome(34000.0);
			doc2.setSpecialization("medicine");
		
			Doctor doc3 = new Doctor();
			doc3.setIncome(6500.0);
			doc3.setDocName("Mahi");
			doc3.setSpecialization("ortho");
			// String msg = service.registerGroupOfDoctors(List.of(doc1, doc2, doc3));
		
			// OR using array
			String msg = service.registerGroupOfDoctors(Arrays.asList(doc1, doc2, doc3));
			System.out.println(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
		/*// Count all object(record) from db
		try {
			System.out.println("Count of records: " + service.fetchDoctorsCount());
		
		} catch (Exception e) {
			e.printStackTrace();
		}*/

		/*// check object(record) by id
		try {
			System.out.println("09 id doctor exists ?:: " + service.checkDoctorAvailbility(9));
		
		} catch (Exception e) {
			e.printStackTrace();
		}*/

		// gives all the records of the table in from of
		// iterable/List of entity class object using finAll() method

		/*try {
			Iterable<Doctor> it = service.showAllDoctors();
			System.out.println("java8 forEach() method");
			it.forEach(doc -> {
				System.out.println(doc.toString());
			});
			System.out.println("Improved forEach() method");
			it.forEach(doc1 -> System.out.println(doc1));
		
			System.out.println("forEach() + static method reference");
			it.forEach(System.out::println);
		
			System.out.println("java5 enhanced for loop");
			for (Doctor doc : it) {
				System.out.println(doc);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/

		// show all Doctors object by method
		// Iterable<Doctor> methodName(Iterable<Integer>ids);

		/*try {
			service.showAllDoctorsByIds(List.of(1, 2, 4, 6, 7, 10)).forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		}*/

		/*
				// show the single object
				try {
					Doctor doctor = service.showDoctorById(9);
					System.out.println(doctor);
		
				} catch (Exception e) {
					e.printStackTrace();
				}*/
		/*
				// update single object by save() method
				try {
					System.out.println(" 10 doctor info before update: " + service.showDoctorById(10));
					System.out.println(service.updateDoctorIncomeById(10, 10.0f));
					System.out.println("10 doctor info after update: " + service.showDoctorById(10));
		
				} catch (Exception e) {
					e.printStackTrace();
				}*/

		// register or update object using save() method
		/*try {
			// get the Doctor class object
			Doctor doc = new Doctor();
			doc.setDocId(12);
			doc.setDocName("Soni");
			doc.setIncome(29050.0);
			doc.setSpecialization("phy");
			System.out.println(service.registerOrUpdateDoctor(doc));
		
		} catch (Exception e) {
			e.printStackTrace();
		}*/

		/*	// delete single object by id
			try {
				System.out.println(service.deleteDoctorById(12));
			} catch (Exception e) {
				e.printStackTrace();
			}*/

		/*	// delete single object using Entity class id
			try {
				// get the Doctor class object =OR
				Doctor doc1 = new Doctor();
				doc1.setDocId(8);
		
				System.out.println(service.deleteDoctor(doc1));
			} catch (Exception e) {
				e.printStackTrace();
			}*/

		/*// delete all records from db
		try {
			System.out.println(service.removeAllDoctors());
		} catch (Exception e) {
			e.printStackTrace();
		}*/

		// deletes object by multiple ids
		try {
			System.out.println(service.removeDoctorsById(List.of(11, 17)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
