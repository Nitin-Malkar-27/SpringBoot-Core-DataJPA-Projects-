package com.nt.runner;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class TestCmdLineRunner implements CommandLineRunner {

	@Override
	@Order(10)
	public void run(String... args) throws Exception {
		System.out.println("TestCmdLineRunner.run()");

		System.out.println("Runner to test ...." + Arrays.toString(args));
		
	}

}
