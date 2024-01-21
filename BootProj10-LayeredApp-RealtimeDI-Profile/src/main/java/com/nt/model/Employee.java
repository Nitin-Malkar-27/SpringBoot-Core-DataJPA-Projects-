//Employee.java
package com.nt.model;

import lombok.Data;

@Data
public class Employee {
	private Integer empno;
	private String ename;
	private String desg;
	private Double salary;
	private Double grossSalary;
	private Double netSalary;
	// setters && getters (not required if ur using lombok api)
	// process :: select the properties -->right click -->source -->generate
	// setters& getters
	// alt+shift+s , r (shortcut key)

}
