package com.nt.beans;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component("comp")
@Data
public class Company {

	private Integer id;
	private String name;
	private String addrs;
	private String size;
}
