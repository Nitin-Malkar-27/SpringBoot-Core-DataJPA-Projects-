package com.nt.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Employee_info {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer eno;
	private String desg;
	private Double salary;
	private double gross_salary;
	private double net_salary;
}
