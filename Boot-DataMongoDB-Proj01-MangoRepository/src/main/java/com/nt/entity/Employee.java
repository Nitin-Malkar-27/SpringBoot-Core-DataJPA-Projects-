package com.nt.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

//@Document
@Document(collection = "Employee")
@Data
public class Employee {

	@Id
	private String id;
	private Integer eno;
	private String ename;
	private String eadd;
	private Double salary;
	private Boolean isVaccinated;

}
