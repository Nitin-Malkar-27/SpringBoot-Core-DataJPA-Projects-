package com.nt.runner;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Doctor;
import com.nt.service.IDoctorMgmtService;

@Component
public class QueryMethodTestRunner implements CommandLineRunner {

	@Autowired
	private IDoctorMgmtService service;

	@Override
	public void run(String... args) throws Exception {
		service.showDoctorsByIncomeRange(10000, 40000).forEach(System.out::println);

		System.out.println("=======Select --Entity Query===============");
		service.searchDoctorBySpecialization("cardio", "ortho").forEach(System.out::println);

		System.out.println("---Select --Entity Projection Query_(Specific multiple col values)--- ");
		/*service.showDoctorsDataByIncome(5000, 40000).forEach(row -> {
			for (Object obj : row) {
				System.out.print(obj + " ");
			}
			System.out.println();
		});
		
		OR
		*/

		service.showDoctorsDataByIncome(5000.0, 40000.0).forEach(row -> {
			System.out.println(Arrays.toString(row));
		});

		System.out.println("---Select --Entity Projection Query(Specific single col value)-----");
		service.showDoctorsDataByIncomeRange(3000.0, 30000.0).forEach(System.out::println);

		System.out.println("-----------Entity Query giving single record-----");
		Doctor doctor = service.searchDoctorByNameDocName("Mahi");
		System.out.println("Doctor info " + doctor);

		System.out.println("/n--Scalar Query giving single reocrd multiple col values---");
		Object obj = service.searchDoctorDataByName("Mahi");
		Object data[] = (Object[]) obj;
		for (Object o : data) {
			System.out.print(o + " ");
		}
		System.out.println();
		// OR
		System.out.println("Result is:: " + Arrays.toString(data));

		System.out.println("/n-Scalar Query giving single record single col values--");
		String result = service.searchSpecializationByName("Mahi");
		System.out.println("Specialization:: " + result);

		System.out.println("HQL/JPQL supts aggregate operations like count(*),max(-),min(-),avg(-) & etc");
		System.out.println("Unique doctor name count:: " + service.showDoctorNamesCount());

		System.out.println("--------------------------------------------------------");
		Object[] result1 = (Object[]) service.showAggregateData();

		System.out.println("Records count:: " + result1[0]);
		System.out.println("Max income value:: " + result1[1]);
		System.out.println("Min income value:: " + result1[2]);
		System.out.println("Sum of income:: " + result1[3]);
		System.out.println("Avg of income:: " + result1[4]);

		System.out.println(" ------------- Non-select Operations using  HQL/JPQL -------");
		int count = service.appraiseDoctorsIncomeBySpecialization("cardio", 10.0);
		System.out.println("no.of recored that are affected:: " + count);

		System.out.println("------------------------------------------------------");
		System.out.println("Deleted doctors count:: " + service.fireDoctorsByIncomeRange(4000, 6000));

		System.out.println("/n -------------native SQL Queries----------");
		System.out.println(service.insertDoctor("Rajesh", 40000, "cardio"));

		System.out.println("/n ----show System Date---------");
		System.out.println("System datetime:: " + service.showSystemDate());

		System.out.println("=-----DB table creation-----");
		System.out.println(service.createTempDBTable());
	}

}
