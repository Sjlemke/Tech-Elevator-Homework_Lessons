package com.techelevator;

import org.apache.commons.dbcp2.BasicDataSource;

import com.techelevator.city.City;
import com.techelevator.city.CityDAO;
import com.techelevator.city.JDBCCityDAO;

public class DAOExample {

	public static void main(String[] args) {
	
		BasicDataSource worldDataSource = new BasicDataSource();
		worldDataSource.setUrl("jdbc:postgresql://localhost:5432/world");
		worldDataSource.setUsername("postgres");
		worldDataSource.setPassword("postgres1");
		
		CityDAO dao = new JDBCCityDAO(worldDataSource);
		
		City smallville = new City();   //Instantiate a new, empty City object
		smallville.setCountryCode("USA");  //Assign values 
		smallville.setDistrict("KS");      // to the new City object
		smallville.setName("Smallville");  //using its setters
		smallville.setPopulation(42080);
		     //Note: we did not a city_id because it comes from the data base manager
		dao.save(smallville);  //Use the DAO 
		
		City theCity = dao.findCityById(smallville.getId());
		
	}

}
