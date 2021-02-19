package com.techelevator;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.jdbc.JDBCDepartmentDAO;
	
@FixMethodOrder(MethodSorters.NAME_ASCENDING) //List tests in alphabetical order when you run them
	
public class TestJDBCDepartmentDAO {
	
	private static SingleConnectionDataSource dataSource; //define a refernce to a data source to use in the tests
	
	private JDBCDepartmentDAO departmentDAO; // define a refernce to the JDBC/DAO we want to test
	
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
   
	    departmentDAO = new JDBCDepartmentDAO(dataSource);
   }
   // instantiate an object constaining the methods we want to test ans assign to the reference above 
   @After
   public void testTakeDown() throws SQLException {
	   dataSource.getConnection().rollback();  //rollback after every test so test is not permanently stored in the DB
   }   
	   //_____________________set up stuff is done___ now write tests below__
   
	   
	@Test
	public void testCreateDepartment() {  //arrange - set up data
		                                   //create a new department to add to teh database 
		  Department newDepartment = new Department();
		                                  //assert - verify method did what is was supposed to
		  
		  newDepartment.setName("Sales");
		  
		  Department returnedDepartment;
		  
		  returnedDepartment = departmentDAO.createDepartment(newDepartment);
		  
		  assertNotNull(returnedDepartment);
		  assertEquals(newDepartment.getName(), returnedDepartment.getName());
		  
	  }
	   
 
}

