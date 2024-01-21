package com.nt.runner;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.model.prod.Product;
import com.nt.model.promotions.Offers;
import com.nt.repo.prod.IProductRepo;
import com.nt.repo.promotions.IOffersRepo;

@Component
public class MultiDataSourceTestRunner implements CommandLineRunner {
	@Autowired
	private IProductRepo productRepo;

	@Autowired
	private IOffersRepo offerRepo;;

	@Override
	public void run(String... args) throws Exception {

		// saVE THE object

		productRepo.saveAll(Arrays.asList(new Product("table", 100.0, 60000.0), new Product("chair", 200.0, 34000.0),
				new Product("sofa", 150.0, 56000.0)));
		System.out.println("Products are saved");
		System.out.println("=======================================================");
		offerRepo
				.saveAll(Arrays.asList(new Offers("Buy-1-Get-1", "B1G1", 100.0, LocalDateTime.of(2022, 11, 22, 20, 20)),
						new Offers("Buy-1-Get-2", "B1G2", 200.0, LocalDateTime.of(2021, 10, 23, 34, 54)),
						new Offers("Buy-1-Get-3", "B1G3", 50.0, LocalDateTime.of(2020, 4, 23, 11, 44))));
		System.out.println("Offers are saved");
	}

}
