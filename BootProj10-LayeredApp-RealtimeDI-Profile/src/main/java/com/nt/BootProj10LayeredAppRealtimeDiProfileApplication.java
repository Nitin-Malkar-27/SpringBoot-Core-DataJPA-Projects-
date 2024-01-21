package com.nt;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.nt.controller.PayrollOperationsController;
import com.nt.model.Employee;

@SpringBootApplication
public class BootProj10LayeredAppRealtimeDiProfileApplication {

	/*@Bean(name="c3P0Ds")
	public  ComboPooledDataSource  createC3P0Ds()throws Exception {
		  ComboPooledDataSource  cds=new ComboPooledDataSource();
		  cds.setDriverClass("oracle.jdbc.driver.OracleDriver");
		  cds.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		  cds.setUser("system");
		  cds.setPassword("tiger");
		  cds.setMinPoolSize(10);
		  cds.setMaxPoolSize(100);
		  return cds;
	}*/

	@Autowired
	private Environment env;

	@Bean(name = "c3P0Ds")
	@Profile("test")
	public ComboPooledDataSource createC3P0Ds() throws Exception {
		System.out.println("BootProj03LayeredAppRealtimeDiApplication.createC3P0Ds()");
		ComboPooledDataSource cds = new ComboPooledDataSource();
		cds.setDriverClass(env.getProperty("spring.datasource.driver-class-name"));
		cds.setJdbcUrl(env.getProperty("spring.datasource.url"));
		cds.setUser(env.getProperty("spring.datasource.username"));
		cds.setPassword(env.getProperty("spring.datasource.password"));

		cds.setMinPoolSize(Integer.parseInt(env.getProperty("c3P0.minSize")));
		cds.setMaxPoolSize(Integer.parseInt(env.getProperty("c3P0.maxSize")));
		return cds;
	}

	public static void main(String[] args) {

		// read inputs from the enduser
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter employee name::");
		String name = sc.next();
		System.out.println("Enter employee desg::");
		String desg = sc.next();
		System.out.println("Enter employee basicSalary::");
		double basicSalary = sc.nextDouble();
		// create the Employee class object
		Employee emp = new Employee();
		emp.setDesg(desg);
		emp.setEname(name);
		emp.setSalary(basicSalary);

		// get IOC container
		ApplicationContext ctx = SpringApplication.run(BootProj10LayeredAppRealtimeDiProfileApplication.class, args);
		// get Controller class object
		PayrollOperationsController controller = ctx.getBean("payrollController", PayrollOperationsController.class);
		// invoke the method
		try {
			String result = controller.processEmployee(emp);
			System.out.println(result);
		} // try
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Internal Problem--- Try again " + e.getMessage());
		}
		// close the container
		((ConfigurableApplicationContext) ctx).close();
	}// main

}// class
