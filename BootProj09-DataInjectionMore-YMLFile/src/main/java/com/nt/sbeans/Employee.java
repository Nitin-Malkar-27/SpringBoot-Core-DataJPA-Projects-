package com.nt.sbeans;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component("emp")
@ConfigurationProperties(prefix = "org.nit")

public class Employee {

	// simple properties
	private String eno;
	private String ename;

	// array properties
	private String[] favColors;

	// collection type properties
	private List<String> nickNames;
	private Set<Long> phoneNumbers;
	private Map<String, Object> idDetails;

	// HAS-A properties
	private Company company;
}
