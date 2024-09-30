package com.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name="employee")
public class EmployeeEntity {
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  @Column(name="employee_id", length=45)
  private int employeeid;
  
  @Column(name="employee_name", length=255)
  private String employeename;
  
  @Column(name="email", length=255)
  private String email;
  
  @Column(name="password", length=255)
  private String password;

public EmployeeEntity(int employeeid, String employeename, String email, String password) {
	super();
	this.employeeid = employeeid;
	this.employeename = employeename;
	this.email = email;
	this.password = password;
}

public EmployeeEntity() {
	super();
	// TODO Auto-generated constructor stub
}

public int getEmployeeid() {
	return employeeid;
}

public void setEmployeeid(int employeeid) {
	this.employeeid = employeeid;
}

public String getEmployeename() {
	return employeename;
}

public void setEmployeename(String employeename) {
	this.employeename = employeename;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

@Override
public String toString() {
	return "EmployeeEntity [employeeId=" + employeeid + ", employeename=" + employeename + ", email=" + email
			+ ", password=" + password + "]";
}
  
  
}
