package com.techelevator.projects.model;

import java.time.LocalDate;

public class Project {
	// TODO: Place code to describe the columns in the table row here
	private long project_id;
	private String name;
	private LocalDate from_date;
	private LocalDate to_date;

	
	public long getProject_id() {
		return project_id;
	}
	public void setProject_id(long project_id) {
		this.project_id = project_id;
	}
		
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name; }
	
	public LocalDate getFrom_date(LocalDate from_date) {
		return from_date;
	}
	
	public void setFrom_date(LocalDate to_date) {
		this.to_date = to_date;
	}
	
	public LocalDate getTo_date() {
		return to_date;
	}
	
   public void setTo_date(LocalDate to_date) {
	   this.to_date = to_date;
   }
   @Override
   public String toString() {
	   return "Project [name" + name + "]";
   }
   
   
}
