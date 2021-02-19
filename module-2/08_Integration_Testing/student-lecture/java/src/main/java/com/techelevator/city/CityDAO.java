package com.techelevator.city;

import java.util.List;

public interface CityDAO {

	public void save(City newCity);  //Add a new row using a City object

	public City findCityById(long id);  //Search the DB for a city with the id given and return it

	public List<City> findCityByCountryCode(String countryCode); //search DB for the city withthe countrycode given and return 

	public List<City> findCityByDistrict(String district);  //Search the DB for a city with the district given and return it

	public void update(City city); //Update a row in the DB with the data in a city object passed to it

	public void delete(long id); //Delete a row from the DB for the id passed to it
}
