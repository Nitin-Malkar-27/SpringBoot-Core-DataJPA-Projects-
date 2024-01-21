package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.sbeans.Employee;

@SpringBootApplication
public class BootProj09DataInjectionMoreYmlFileApplication {

	public static void main(String[] args) {
		// create the IOC Container

		ApplicationContext ctx = SpringApplication.run(BootProj09DataInjectionMoreYmlFileApplication.class, args);

		// create the object for Employee class
		Employee emp = ctx.getBean("emp", Employee.class);
		System.out.println(emp);
//close the IOC container
		((ConfigurableApplicationContext) ctx).close();
	}

}
