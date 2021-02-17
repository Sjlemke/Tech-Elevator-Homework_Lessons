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
		ArrayList<Department> listOfDepartments = new ArrayList<Department>();
		
		String getAllDepartmentsSQL = "Select department_id, name from department";
		
		
		SqlRowSet theDepartments = jdbcTemplate.queryForRowSet(getAllDepartmentsSQL);
		
		while(theDepartments.next()) {
			  Department aDepartment = MapRowToDepartment(theDepartments); {
			  }
		}
		return listOfDepartments;
	}

	@Override
	public List<Department> searchDepartmentsByName(String nameSearch) {
		ArrayList<Department> listOfDepartments = new ArrayList<Department>();
		
		String searchDepartmentNameSQL = "Select department_id from department where name = ?";
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
		String = updateDepartment = "UPDATE department " +
	                                "SET name = ? ";
		                            "WHERE department_id = ?";
	
	jdbcTemplate.update(updateDepartment, updateDepartment.getName(), updateDepartment.getId());
			
	}

	@Override
	public Department createDepartment(Department newDepartment) {
		
		
		return null;
	}

	@Override
	public Department getDepartmentById(Long id) {
		
		
		return null;
	}
 
	public Department MapRowToDepartment(SqlRowSet results) {
	Department theDepartment;
	theDepartment = new Department();
	theDepartment.setDepartment_id(results.getLong("department_id"));
	theDepartment.setName(results.getString("name"));
		
		return theDepartment; 
	}
	
}
