package com.techelevator.city;
//Integration Testing - Testing to ensure your code interacts with external process correctly
//You want to be sure your code doesnt break when working with external code
//Unit Testing was what we did before- that ensured that class methods worked within the application program
//When using DAOs we are Interacting with external resource/process called a data base manager
//Gonna use JUNIT again, but with some new techniques and methods. 
//We need to verify that the INSERT, UPDATE, DELETE was done correctly in the DBM
//BeforeClass and AfterClass are the new methods for JUNIT

//You can use DAO interface to determine which methods you need to test - they interact with the DBM
// DEFINE DATA WITH VALUES YOU KNOW WILL NOT AND CANNOT BEIN THE DB


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JDBCCityDAOIntegrationTest {

	private static final String TEST_COUNTRY = "XYZ"; //WE KNOW THERE IS NO COUNTRY CODE "XYZ" IN DATABASE
                                                     //WHEN WE NEED A COUNTRY CODE FOR A TEST WE WILL USE THIS CONSTANT 
	/* Using this particular implementation of DataSource so that
	 * every database interaction is part of the same database
	 * session and hence the same database transaction */
	
	
	//Previously we used  a BasicDataSource
	//we used a SingleConnectionDatabase due to its efficiencies over the BasicDataSource
	       //and to give you an example of another data source
	       // Both data source classes have the same constructor format and methods
	      // Define a reference to the DAO we are testing
	       //the data source object is instantiated and assigned in the set up method
	       //the DAO is instantiated ans assigned before use 
	private static SingleConnectionDataSource dataSource;
	private JDBCCityDAO dao;

	/* Before any tests are run, this method initializes the datasource for testing. */
	@BeforeClass  //tells JUnit to do this once before it does anything else at the starts of testing
	             //When testing DAOs, instantiating and assigning the data source is a common process in a before class
	             //put any set up that all tests need to be done once before they start. Thats what the @BeforeCLass is all about. 
	public static void setupDataSource() {     //name of the Junit test method
		dataSource = new SingleConnectionDataSource();   //instantiating and assigning the datasource to our reference
		dataSource.setUrl("jdbc:postgresql://localhost:5432/world");  //set the connection string for the datasource 
		dataSource.setUsername("postgres");                           //set the database owner of the database we are using
		dataSource.setPassword("postgres1");                         // set database owner of the database we are using
		/* The following line disables autocommit for connections     //set the password for the database . Postgres1
		 * returned by this DataSource. This allows us to rollback
		 * any changes after each test */
		dataSource.setAutoCommit(false);  //tells the datasource NOT to automatically commit after each interaction 
		                                  //We want to control the commit 
	}

	/* After all tests have finished running, this method will close the DataSource */
	@AfterClass    //Tells JUnit to do this once at the end of all tests before you end the testing session
	                //Usually this is where you disconnect from the DBM to avoid resource by leaving connect open
	public static void closeDataSource() throws SQLException {
		dataSource.destroy();     //Disconnect the datasource from the database manager
	}

	
	//Do not use "live" data in the DB for your tests - it might change between tests - tests must be reliable. 
	//So you want to add data to the DB specifically for testing purposes so you know the data is there and wont change
	//Add data with values you know are not or cannot be in the DB already. 
	//Rollback any test data added when the test completes. 
	
	
	
	@Before  //Do this before every JUNIT test - setup the database with data to be used in the tests
	public void setup() {
		    //Add a row to country table with the TEST_COUNTRY value primary key so we can use the row in tests
		String sqlInsertCountry = "INSERT INTO country "
				                  + (code, name, continent, region, surfacearea, indepyear, population, lifeexpectancy, gnp, gnpold, localname, governmentform, headofstate, capital, code2) 
				                  + VALUES (?, 'Afghanistan', 'Asia', 'Southern and Central Asia', 652090, 1919, 22720000, 45.9000015, 5976.00, NULL, 'Afganistan/Afqanestan', 'Islamic Emirate', 'Mohammad Omar', 1, 'AF')";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(sqlInsertCountry, TEST_COUNTRY);
		    //Instantiate an object for the DAO containing the methods we want to test
		    // We do this before each test so we get a clean, unused JDBC/DAO object for each test
		    // If we share the JDBC/DAO with all tests, the results may differ due to values left in the JDBC/DAO after use
		dao = new JDBCCityDAO(dataSource);
	}

	/* After each test, we rollback any changes that were made to the database so that
	 * everything is clean for the next test */
	@After //Do this after every JUNIT test - rollback any data added for hte test. 
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}

	@Test  //THis is the start of our testing. 
	public void save_new_city_and_read_it_back() throws SQLException {
		   //Arrange - setup data needed to the test
		City theCity = getCity("SQL Station", "South Dakota", "USA", 65535); //Instantiate a City object using a common method
		                //                                                  //define near the end of the testing class. 

		dao.save(theCity);  //ACT - perform the process/ call method you are testing. Calling DAO save method with a new city object we created for the test. 
		                    //ASSERT - verify that the process / method did what it was supposed to 
		City savedCity = dao.findCityById(theCity.getId());  //Get the row just added to the database with the id in the object used to test the method
        
		assertNotEquals(null, theCity.getId());  //be sure id added was not null 
		assertCitiesAreEqual(theCity, savedCity); //Be sure the data retrieved from the database matches the data we sent 
		                                         //using a helper method 
	}

	@Test
	public void returns_cities_by_country_code() {
		City theCity = getCity("SQL Station", "South Dakota", TEST_COUNTRY, 65535);

		dao.save(theCity); //Save the test city to the DB
		List<City> results = dao.findCityByCountryCode(TEST_COUNTRY);
                                       //ACT- perform the process/call the method you are testing
		                               //Try to get all the cities with the test country code - we know there should only one
		//Assert - verify process did what it was supoosed to 
		assertNotNull(results);     //verify that something was returned - at least on city in the list 
		assertEquals(1, results.size());  //verify that exactly one city was returned - only one can have the test country code
		City savedCity = results.get(0);  //Get the city out of the list that was returned 
		assertCitiesAreEqual(theCity, savedCity);  //an be sure it matches the city we sent to be stored 
	}

	@Test
	public void returns_multiple_cities_by_country_code() {
           //Instantiate multiple new cities with the test country - they will be only ones in the table with the test country code
		  //and add them to teh data base
		dao.save(getCity("SQL Station", "South Dakota", TEST_COUNTRY, 65535));  //create a temporary city object and add it to teh DB
		dao.save(getCity("Postgres Point", "North Dakota", TEST_COUNTRY, 65535)); //Create temp city object and add it to the DB
          //Act - get all the cities with the test county code - we know there should only be two. 
		List<City> results = dao.findCityByCountryCode(TEST_COUNTRY);
              //ASSERT - did at least one city get returned? 
		assertNotNull(results);
		assertEquals(2, results.size());  //did exactly 2 cities get returned?
	}

	@Test
	public void returns_cities_by_district() {
		String testDistrict = "Tech Elevator";
		City theCity = getCity("SQL Station", testDistrict, TEST_COUNTRY, 65535);
		dao.save(theCity);

		List<City> results = dao.findCityByDistrict(testDistrict);

		assertNotNull(results);
		assertEquals(1, results.size());
		City savedCity = results.get(0);
		assertCitiesAreEqual(theCity, savedCity);
	}
//____________________________________________________________________________________//
	//       these below are helper methods to set up data for the tests - commnonly needed process
	private City getCity(String name, String district, String countryCode, int population) {
		City theCity = new City();
		theCity.setName(name);
		theCity.setDistrict(district);
		theCity.setCountryCode(countryCode);
		theCity.setPopulation(population);
		return theCity;
	}
                          //Helper method to test if two city objects are equal 
	private void assertCitiesAreEqual(City expected, City actual) {
		assertEquals(expected.getId(), actual.getId());
		assertEquals(expected.getName(), actual.getName());
		assertEquals(expected.getDistrict(), actual.getDistrict());
		assertEquals(expected.getCountryCode(), actual.getCountryCode());
		assertEquals(expected.getPopulation(), actual.getPopulation());
	}
}
