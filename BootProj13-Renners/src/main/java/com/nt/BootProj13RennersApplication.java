package com.nt;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BootProj13RennersApplication {

	
	// if spring App both runners are Functional interfaces. so we develop
	//runners logics directly in main class without taking separate classes
	//but industry standard is separate classes
	
	@Bean
	public CommandLineRunner createCmdRunner() {
		System.out.println("BootProj13RennersApplication.createCmdRunner()");
		CommandLineRunner cmd=args->{
			System.out.println("Runner from main class");
			System.out.println(Arrays.toString(args));
		};
		return cmd;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(BootProj13RennersApplication.class, args);
	}

}
