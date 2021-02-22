package com.techelevator;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.Project;
import com.techelevator.projects.model.ProjectDAO;
import com.techelevator.projects.model.jdbc.JDBCDepartmentDAO;
import com.techelevator.projects.model.jdbc.JDBCProjectDAO;

public class testJDBCProjectDAO {
	
	private static SingleConnectionDataSource dataSource; //define a refernce to a data source to use in the tests
	
	private JDBCProjectDAO projectDAO; // define a refernce to the JDBC/DAO we want to test
	
	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/projectsDAO");
	    dataSource.setUsername("postgres");
	    dataSource.setPassword("postgres1");
	    dataSource.setAutoCommit(false);
	                  //this disables autocommit for connections. this allows us to rollback any changes after test
	
	}
   @AfterClass
   public static void closeDataSource() throws SQLException {
	   dataSource.destroy();
   }
   
   //set up anything you need to do before eery test and after every test.
   @Before  //this will be done before each and every test is run
   public void testSetup() { //instantiate a new jdbctemplate object for use in teh test
	    JdbcTemplate theDataBase = new JdbcTemplate(dataSource);
   
	    projectDAO = new JDBCProjectDAO(dataSource);
   }
   // instantiate an object constaining the methods we want to test ans assign to the reference above 
   @After
   public void testTakeDown() throws SQLException {
	   dataSource.getConnection().rollback();  //rollback after every test so test is not permanently stored in the DB
   } 
	
	

	@Test
	public void getAllActiveProjects() {                             //ASK ABOUT THIS
		List<Project> results = projectDAO.getAllActiveProjects();
		assertNotNull(results);
		assertEquals(projectDAO.getAllActiveProjects().size(), results.size());
	}
	
	@Test
	public void removeEmployeeFromProject() {
		String sqlGetProjectById = "SELECT employee_id " +
	                                "FROM project_employee " +
				                    "WHERE project_id = 6 ";
	    JdbcTemplate theDataBase = new JdbcTemplate(dataSource);

		SqlRowSet ProjectBy_id = theDataBase.queryForRowSet(sqlGetProjectById);
		assertNotNull(ProjectBy_id);
		projectDAO.removeEmployeeFromProject(6L , 5L);
		ProjectBy_id = theDataBase.queryForRowSet(sqlGetProjectById);
		assertNotNull(ProjectBy_id);
     	
	}
	
	
	@Test
	public void addEmployeeToProject() { 
		projectDAO.addEmployeeToProject(5L , 5L);
		String sqlGetProjectById = "SELECT employee_id " +
                                   "FROM project_employee " +
                                   "WHERE project_id = 5 ";
     JdbcTemplate theDataBase = new JdbcTemplate(dataSource);

     SqlRowSet ProjectBy_id = theDataBase.queryForRowSet(sqlGetProjectById);
     assertNotNull(ProjectBy_id);
		
	}
}	















