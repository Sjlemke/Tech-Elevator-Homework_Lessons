package com.techelevator.projects.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.DepartmentDAO;

public class JDBCDepartmentDAO implements DepartmentDAO {
	
	private JdbcTemplate jdbcTemplate;

	public JDBCDepartmentDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Department> getAllDepartments() {
		ArrayList<Department> listOfDepartments = new ArrayList<>();
		
		String sqlgetAllDepartments = "Select department_id, name " +
		                             "From department ";
		SqlRowSet allDepartments = jdbcTemplate.queryForRowSet(sqlgetAllDepartments);
		while(allDepartments.next()) {
			Department theDepartment = MapRowToDepartment(allDepartments);
			listOfDepartments.add(theDepartment);
		}
				
        return listOfDepartments;
			  
		}	

	@Override
	public List<Department> searchDepartmentsByName(String nameSearch) {
		ArrayList<Department> listOfDepartments = new ArrayList<Department>();
		
		String searchDepartmentNameSQL = "Select department_id, name from department where name = ?";
		SqlRowSet theDepartment = jdbcTemplate.queryForRowSet(searchDepartmentNameSQL, nameSearch);
		if(theDepartment.next()) {
			Department aDepartment = new Department();
			aDepartment = MapRowToDepartment(theDepartment);
			listOfDepartments.add(aDepartment);
		}
		
		return listOfDepartments;
	}

	@Override
	public void saveDepartment(Department updatedDepartment) {
		String updateDepartment = "UPDATE department " +
								"Set name = ? " +
								"Where department_id = ?";
		jdbcTemplate.update(updateDepartment, updatedDepartment.getName(), updatedDepartment.getDepartment_id());
	}
	
	
	@Override
	public Department createDepartment(Department newDepartment) {
			String sqlInsertDepartment = "INSERT INTO department(department_id, name) " +
					   				"VALUES(?, ?)"; 
	        newDepartment.setDepartment_id(getNextDepartmentID());  
	        jdbcTemplate.update(sqlInsertDepartment, newDepartment.getDepartment_id(),         
	        						newDepartment.getName());        							
			return newDepartment;
		}

	@Override
	public Department getDepartmentById(Long id) {
		Department aDepartment = new Department();
		String sqlGetDepartmentById = "SELECT department_id, name" +
		                             "From department " +
				                     "Where department_id = ?";
		SqlRowSet DepartmentById = jdbcTemplate.queryForRowSet(sqlGetDepartmentById, id);
		aDepartment = MapRowToDepartment(DepartmentById);
		
		
		return aDepartment;
	}
 
	public Department MapRowToDepartment(SqlRowSet results) {
	Department theDepartment;
	theDepartment = new Department();
	theDepartment.setDepartment_id(results.getLong("department_id"));
	theDepartment.setName(results.getString("name"));
		
		return theDepartment; 
	}
	
	private long getNextDepartmentID() {
		SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextval('seq_department_id')");
		if(nextIdResult.next()) {               // if the SQLRowSet called nextIDResult has any data, move to the next line of data
			return nextIdResult.getLong(1);     // get the long value in column 1 of the line and return it
		} else {                                // if there is no data in nextIDResult, throw a RuntimeException
			throw new RuntimeException("Something went wrong while getting an id for the new city");
		}
	}
	
	
	
	
}
