package com.nt.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class AlterCmdLineRunner implements CommandLineRunner {

	@Override
	@Order(10)
	public void run(String... args) throws Exception {
		System.out.println("AlterCmdLineRunner.run()... the cmf line args are");

		for (String arg : args) {
			System.out.println(arg);
		}
	}

}
