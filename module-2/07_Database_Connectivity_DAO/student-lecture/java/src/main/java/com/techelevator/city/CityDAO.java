package com.techelevator.city;
// This is the DAO Interface for the City table in the world database
//The name should be: table_nameDAO

//It identifies methods that must be implemented in order to use this DAO for city table
// Typically CRUD processes are required methods for a Spring DAO
//Other methods may also be required at the DAO designeds discretion

//This DAO Interface gives examples of common processing requirements for a Spring DAO
//Objects of the class are used to insert and update, rather than indivual variables.
//Not included in this DAO, but common is a method to return all rows in the table as a List
import java.util.List;

public interface CityDAO {

	public void save(City newCity);  //Add/Create a row to the table using an object of the class
	
// One or more search methods to retrieve data in the table 	
	public City       findCityById(long id);
	public List<City> findCityByCountryCode(String countryCode);
	public List<City> findCityByDistrict(String district);
	public void update(City city);  //update a row in the table using an object of the the class
	public void delete(long id);    //Delete a row from the table using the id passed at a parameter
	                                //the parameter is usually the columns in the primary 
}
