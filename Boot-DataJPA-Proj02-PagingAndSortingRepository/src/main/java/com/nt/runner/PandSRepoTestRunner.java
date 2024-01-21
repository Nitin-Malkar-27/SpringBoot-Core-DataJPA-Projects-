package com.nt.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.nt.entity.Doctor;
import com.nt.service.DoctorMgmentServiceImpl;

@Component
public class PandSRepoTestRunner implements CommandLineRunner {

	@Autowired
	private DoctorMgmentServiceImpl service;

	@Override
	public void run(String... args) throws Exception {
		service.showDoctorsBySorting(true, "docName").forEach(System.out::println);
		System.out.println("--------------------------");
		service.showDoctorsBySorting(false, "income", "docName").forEach(System.out::println);

		System.out.println("                                            ");

		System.out.println("..........FindAll(Pageable pageable()..........");
		try {
			// service.showDoctorsInfoByPageNo(1, 5,
			// true,"docName").forEach(System.out::println);

			/*Page<Doctor> page = service.showDoctorsInfoByPageNo(2, 3, false, "docName");
			
			System.out.println("Page number:: " + page.getNumber());
			System.out.println("Page count:: " + page.getTotalPages());
			System.out.println("is it first page:: " + page.isFirst());
			System.out.println("is it last page:: " + page.isLast());
			System.out.println("page size:: " + page.getSize());
			System.out.println("page elements count:: " + page.getNumberOfElements());
			
			if (!page.isEmpty()) {
				List<Doctor> list = page.getContent();
				list.forEach(System.out::println);
			} else {
				System.out.println("no page found");
			}*/
			
			service.showDataThroughPagination(3);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
