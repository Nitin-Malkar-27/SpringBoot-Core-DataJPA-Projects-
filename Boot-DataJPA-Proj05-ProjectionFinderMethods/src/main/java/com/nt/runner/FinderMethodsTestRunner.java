package com.nt.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.repository.IDoctorRepository;
import com.nt.view.IResultView;
import com.nt.view.IResultView1;
import com.nt.view.IResultView2;

@Component
public class FinderMethodsTestRunner implements CommandLineRunner {
	@Autowired
	private IDoctorRepository doctorRepo;

	@Override
	public void run(String... args) throws Exception {
		Iterable<IResultView> it = doctorRepo.findBySpecializationIn(List.of("cardio", "ortho"));
		it.forEach(doc -> {
			System.out.println(doc.getDocName() + "...." + doc.getIncome());
		});

		System.out.println("--------------------------------------------");
		Iterable<IResultView1> it1 = doctorRepo.findByIncomeBetween(3000, 10000, IResultView1.class);

		it1.forEach(data -> {
			System.out.println(data.getDocName() + "...." + data.getSpecialization());
		});

		System.out.println("..........................................");
		Iterable<IResultView2> it2 = doctorRepo.findByIncomeBetween(5000.0, 50000.0, IResultView2.class);
		it2.forEach(data -> {
			System.out.println(data.getDocName() + "..." + data.getIncome() + "..." + data.getSpecialization());
		});
	}

}
