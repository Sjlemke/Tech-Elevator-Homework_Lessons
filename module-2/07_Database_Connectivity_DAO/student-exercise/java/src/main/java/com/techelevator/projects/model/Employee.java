package com.techelevator.projects.model;

import java.time.LocalDate;

public class Employee {
	// TODO: Place code to describe the columns in the table row here
	private long employee_id;
	private int department_id; 
	private String first_name;
	private String last_name;
    private LocalDate birth_date;
    private String gender; 
    private LocalDate hire_date;
	public long getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(long employee_id) {
		this.employee_id = employee_id;
	}
	public int getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public LocalDate getBirth_date() {
		return birth_date;
	}
	public void setBirth_date(LocalDate birth_date) {
		this.birth_date = birth_date;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public LocalDate getHire_date() {
		return hire_date;
	}
	public void setHire_date(LocalDate hire_date) {
		this.hire_date = hire_date;
	}
	@Override
	public String toString() {
		return "Employee [name=" + last_name + ", " + first_name + "]";
	}


    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}