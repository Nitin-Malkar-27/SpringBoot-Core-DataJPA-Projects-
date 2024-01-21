package com.nt.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class TestAppRunner implements ApplicationRunner {

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("TestAppRunner.run()");

		System.out.println("Non option args values:: " + args.getNonOptionArgs());

		System.out.println("Option args names and values:: ");
		for (String name : args.getOptionNames()) {
			System.out.println(name + "---->" + args.getOptionValues(name));
		}

	}

}
