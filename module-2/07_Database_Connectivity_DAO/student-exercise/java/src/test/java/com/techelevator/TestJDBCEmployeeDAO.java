package com.techelevator;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.Employee;
import com.techelevator.projects.model.jdbc.JDBCEmployeeDAO;

public class TestJDBCEmployeeDAO {

	private String test_first_name = "Jeff";
	private String test_last_name  =  "Winger";
	private LocalDate test_birth_date = LocalDate.of(2020,  01, 01);
	private String test_gender = "M";
    private LocalDate test_hire_date = LocalDate.of(2020, 02, 01); 
    private Long test_department_id = 1L;
    private Long employee_id = 14L;
	
    private static SingleConnectionDataSource dataSource; 
    private JDBCEmployeeDAO dao; 
    
    @BeforeClass
    public static void setupDataSOurce() {
      dataSource = new SingleConnectionDataSource();
      dataSource.setUrl("jdbc:postgresql://localhost:5432/projectsDAO");
      dataSource.setUsername("postgres");
      dataSource.setPassword("postgres1");
      dataSource.setAutoCommit(false);
	}
    
   @AfterClass
   public static void closeDataSource() throws SQLException {
	   dataSource.destroy();
   }
   
   @Before
   public void setup() {
   String sqlInsertEmployee = "Insert INTO employee "
                            + "(employee_id, department_id, first_name, last_name, birth_date, gender, hire_date) "
		                    + "VALUES (14 , 1, 'Jeff', 'Winger', '2020,  01, 01', 'M', '2020, 02, 01')"; 
    JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
    jdbcTemplate.update(sqlInsertEmployee);
    dao = new JDBCEmployeeDAO(dataSource);
   
   }
   @After
   public void rollback() throws SQLException {
   dataSource.getConnection().rollback();
   }
   @Test
   public void test_search_Employee_By_Name() {
	   
	 Employee aEmployee = new Employee();
	 
	 aEmployee.setFirst_name(test_first_name);
	 aEmployee.setLast_name(test_last_name);
	 aEmployee.setBirth_date(test_birth_date);
	 aEmployee.setGender(test_gender);
	 aEmployee.setHire_date(test_hire_date);
	 aEmployee.setDepartment_id(test_department_id);
	 
	 List<Employee> results = dao.searchEmployeesByName(aEmployee.getFirst_name(), aEmployee.getLast_name());
	
	 assertNotNull(results); 
	 assertEquals(1, results.size());
	 assertEquals(results.get(0).getFirst_name(), aEmployee.getFirst_name());
	 assertEquals(results.get(0).getLast_name(), aEmployee.getLast_name());
	 
   }
	@Test
	public void changeEmployeeDepartment() { 
		Employee aEmployee = new Employee();
		dao.changeEmployeeDepartment(1L, 3L); 
		List<Employee> result = dao.searchEmployeesByName("Fredrick", "Keppard");
		assertEquals(3L, result.get(0).getDepartment_id()); 
	}
	
	
	
	@Test
    public void getEmployeesWithoutProjects() {
		Employee aEmployee = new Employee();
		dao.getEmployeesWithoutProjects(); 
		List<Employee> result = dao.getEmployeesWithoutProjects();
		assertEquals(1, result.size());
		
		    }
	
	@Test
	public void getAllEmployees()	{
		List<Employee> results = dao.getAllEmployees();
		assertNotNull(results);
		assertEquals(dao.getAllEmployees().size(), results.size());
	
	}
		
	@Test 
	public void getEmployeesByProjectId() {                   //ASK ABOUT THIS ONE
		List<Employee> results = dao.getEmployeesByProjectId(4L);
		assertNotNull(results);
		assertEquals(dao.getEmployeesByProjectId(4L).size(), results.size());
	
		
		
	} 
	 @Test
	 public void getEmployeesByDepartmentId() {
			List<Employee> results = dao.getEmployeesByDepartmentId(2L );
			assertNotNull(results);
			assertEquals(dao.getEmployeesByDepartmentId(2L).size(), results.size());
		
			
}
}








