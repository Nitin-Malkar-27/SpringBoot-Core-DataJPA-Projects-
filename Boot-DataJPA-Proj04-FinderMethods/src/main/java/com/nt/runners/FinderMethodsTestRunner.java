package com.nt.runners;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.repository.IDoctorRepository;

@Component
public class FinderMethodsTestRunner implements CommandLineRunner {

	@Autowired
	private IDoctorRepository doctorRepo;

	@Override
	public void run(String... args) throws Exception {
		// calling the finder methods
		doctorRepo.findByDocNameEquals("Mukesh").forEach(System.out::println);
		System.out.println("------------------------------------------");
		doctorRepo.findByDocNameIs("rajesh1").forEach(System.out::println);
		System.out.println("------------------------------------------");
		doctorRepo.findByDocName("rajesh1").forEach(System.out::println);
		System.out.println("------------------------------------------");
		doctorRepo.findByIncomeBetween(10000, 40000).forEach(doc -> System.out.println(doc));
		System.out.println("------------------------------------------");
		doctorRepo.findBySpecializationIn(List.of("cardio", "ortho")).forEach(doc -> {
			System.out.println(doc);
		});

		System.out.println("------------------------------------------");
		doctorRepo.findByDocNameLike("r%").forEach(System.out::println);
		System.out.println("------------------------------------------");

		doctorRepo.findByDocNameStartsWith("M").forEach(System.out::println);
		System.out.println("------------------------------------------");
		doctorRepo.findByDocNameEndsWith("h").forEach(System.out::println);
		System.out.println("------------------------------------------");
		doctorRepo.findByDocNameContains("sh").forEach(System.out::println);
		System.out.println("------------------------------------------");

		doctorRepo.findByIncomeGreaterThanEqualAndIncomeLessThanEqual(25000.0, 50000.0).forEach(System.out::println);

		doctorRepo.findBySpecializationInOrIncomeBetween(List.of("cardio", "ortho"), 30000, 40000)
				.forEach(System.out::println);
		System.out.println("------------------------------------------");

	}
}
