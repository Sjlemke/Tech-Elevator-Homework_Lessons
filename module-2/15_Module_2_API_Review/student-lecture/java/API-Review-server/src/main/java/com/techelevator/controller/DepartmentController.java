package com.techelevator.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.techelevator.model.DepartmentDAO;


/**
 * Controller to authenticate users.
 */

public class DepartmentController {
	DepartmentDAO debtDAO; //define a refernce to access its methods
	//constructor for this class - public, same name as the class
	//Use this Spring dependency injection to instantiate a DepartmentDAP object and pass it to the ctor
	public DepartmentController(DepartmentDAO debtDao) {
		this.deptDAO = debtDao;
	}
	
	//write a controller to handle the path to send back all the departments 
	//to send back all departments as an array or a list or map or a queue or a stack 
	@RequestMapping(path=" /departments", method=RequestMethod.GET) //this will handle /departments path
	public List<Department> listAllDepartments() {
		return theDepartments;
		
	}
	//this controller with a get spcific departments from the departments resource based on its id 
	//use the departmentDao getDepartmnetById() method
	//the path the API will use to invoke this is: /departments/{id}
	@RequestMapping(path="/departments/{id}", method=RequestMethod.GET)
	public Department getDepartmentById(PathVariable Long id) {
		logAPICall("Called with the path: /departments/" + id);
		return deptDAO.getDepartmentById(id);
	}
	
public void logAPICall(String message) {
	 LocalDateTime now = LocalDateTime.now();
     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("mm/dd/yyyy HH:mm:ss.A");
     String timeNow = now.format(formatter);
     System.out.println(timeNow + "-" + message);
 }
}


