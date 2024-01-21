package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.sbeans.Customer;

@SpringBootApplication
public class BootProj07YmlFileApplication {

	public static void main(String[] args) {
		// Create the IOC container

		ApplicationContext ctx = SpringApplication.run(BootProj07YmlFileApplication.class, args);

		// get the Customer class object
		Customer cust = ctx.getBean("cust", Customer.class);
		System.out.println(cust);

		// close the IOC container
		((ConfigurableApplicationContext) ctx).close();
	}

}
