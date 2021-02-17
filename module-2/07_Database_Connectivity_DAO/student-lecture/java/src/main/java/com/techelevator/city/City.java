package com.techelevator.city;
   //POJO for accessing the city table data in the world database
   // Class should have the same naem at the table 
   //Although not required, it is recommended the variable names in the POJO match the column names in the table
   //

public class City {
	private Long id;             //serial in the table - serial may be outside range of INT so we use LONG
	private String name;         // varchar in the table
	private String countryCode;  //bpchar in the table
	private String district;     //varchar in the table
	private int population;      //int4 (integer) in the table

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}
}
