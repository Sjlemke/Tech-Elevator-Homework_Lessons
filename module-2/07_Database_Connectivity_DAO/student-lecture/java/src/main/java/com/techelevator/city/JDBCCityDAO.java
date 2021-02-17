package com.techelevator.city;

//This is the DAO concrete class which implements the methods required by the interface

//The name of the class should JDBCtable-nameDAO

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCCityDAO implements CityDAO { //implement the interface for the DAO
//JdbcTemplate class contains all the necessary code to interact with a database using Spring DAOS
	private JdbcTemplate jdbcTemplate; //Define an refernce variable an JdbcTemplate object
	
	public JDBCCityDAO(DataSource dataSource) { //Constructor for the class that takes a datasource as a parameter  
		this.jdbcTemplate = new JdbcTemplate(dataSource); //Instantiate a jdbcTemplate object using the datasource passed
	}                                                     //and assign it to the reference defined above.

	@Override  //create row to the table using an object of the class pass in from the user
	public void save(City newCity) {
		String sqlInsertCity = "INSERT INTO city(id, name, countrycode, district, population) " +
							   "VALUES(?, ?, ?, ?, ?)";  //the ? are placeholders for values specified when the statement is run
		
	     newCity.setId(getNextCityId());                  //In this example the values are coming from the object passed to method
		 //When we add a row to the city table the data base will automatically assign a city id because it is defined as serial in the table 
		//Since the database will assign the city id, we dont know what it will be
	     //So we will ask the data base manager what the next city id is and assign it ourselves
	     //that way city object the user passes will have the city id that is in the data base. 
	     
	     //Which means we dont know what they are until runtime. 
		//Run the SQL statement to access the database using JdbcTemplate object
		//Use the .update method because we are executing and INSERT which changes (updated) the database
		//.update()wants the String with the SQL statement to be executed, followed by any valyes for the ? placeholder
		//                 SQL statement,  valyes-for-the-?'s, - one valye for each ? in the SQL statement String
		jdbcTemplate.update(sqlInsertCity, newCity.getId(),   //id from object passed as value for the first ? in the statement 
										  newCity.getName(),    //name from object passed as value for the second ? in the statemnt 
										  newCity.getCountryCode(),  //countrycode from object passed as value for the third ? in statement
										  newCity.getDistrict(),     // district from object passed as value for the fourth ?
										  newCity.getPopulation());   //population from the object passed as value for the fifth ? 
	}           
	
	
	
	    //Create/Add a row to teh table using an object of the class
	@Override  //Ask cinmpiler to be sure we overriding the methdod required by the DAO interface
	public City findCityById(long id) {
		City theCity = null;
		String sqlFindCityById = "SELECT id, name, countrycode, district, population "+
							   "FROM city "+
							   "WHERE id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindCityById, id);
		if(results.next()) {
			theCity = mapRowToCity(results);
		}
		return theCity;
	}

	@Override
	public List<City> findCityByCountryCode(String countryCode) {
		ArrayList<City> cities = new ArrayList<>();
		String sqlFindCityByCountryCode = "SELECT id, name, countrycode, district, population "+
										   "FROM city "+
										   "WHERE countrycode = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindCityByCountryCode, countryCode);
		while(results.next()) {
			City theCity = mapRowToCity(results);
			cities.add(theCity);
		}
		return cities;
	}

	@Override
	public List<City> findCityByDistrict(String district) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(City city) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	private long getNextCityId() {  
		  //nextval() SQL function will return the next sequential values from a sequence object
		  //a sequence object is used by postgres to generate serial values to a column
		  //A sequence object may be defined by a user an used by postgres will austomattically define one for a serial type
		//Use the jdbcTemplate object to run a SELECT to get the city_id value 
		//Result is stored in the nextIdResult variable as a SQLRowSet
		
		
		//                                                   retrieve nextvalue for seq_city_id sequence object
		SqlRowSet nextIdResult = jdbcTemplate.queryForRowSet("SELECT nextval('seq_city_id')");
		   //We need to get the next city data id out of the SQLRowSet and into a JAVA variable. 
		if(nextIdResult.next()) {  //if the SQLRowSet called nextIDResult has any data, move to the next line of data
			return nextIdResult.getLong(1);  //get the ling value in column 1 of the line and return it
		} else {                          //if there is no data in nextIDResult, throw an exception.
			throw new RuntimeException("Something went wrong while getting an id for the new city");
		}
	}

	private City mapRowToCity(SqlRowSet results) {
		City theCity;
		theCity = new City();
		theCity.setId(results.getLong("id"));
		theCity.setName(results.getString("name"));
		theCity.setCountryCode(results.getString("countrycode"));
		theCity.setDistrict(results.getString("district"));
		theCity.setPopulation(results.getInt("population"));
		return theCity;
	}
}
