package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.sbeans.Company;

@SpringBootApplication
public class BootProj06DataInjectionUsingConfigurationPropertiesAnnotationApplication {

	public static void main(String[] args) {
		// create the IOC container

		ApplicationContext ctx = SpringApplication
				.run(BootProj06DataInjectionUsingConfigurationPropertiesAnnotationApplication.class, args);

		// get the company class object
		Company comp = ctx.getBean("comp", Company.class);
		System.out.println(comp);

		// close the IOC container
		((ConfigurableApplicationContext) ctx).close();
	}

}
