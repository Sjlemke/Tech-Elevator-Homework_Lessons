package com.techelevator.services;

import com.techelevator.models.City;
import com.techelevator.models.Hotel;
import com.techelevator.models.Review;
import org.springframework.web.client.RestTemplate;

public class HotelService {
    //Hold the base/main part of the server URL the user wants us to use 
    private final String API_BASE_URL;
    
    //instantiate an object of a class contaning all the code to support API calls 
    //REST is a protocol for doing SPI calls - we learn more about this later. 
    //RestTemplate/CallAPI is a framework class to support calls
    //When we want to do an API class we will use this RestTemplate object 
    private RestTemplate restTemplate = new RestTemplate();
   //Constructor - accepts the main/base part of the URl, teh user wants us to use
    public HotelService(String apiURL) {
        API_BASE_URL = apiURL;  //assigns the main/base part of the URL the user sent us to our instance variable above
    }

    //this method will go to the API server get all the hotel data and return it in an array of hotels. 
    public Hotel[] listHotels() {
        return null;  //the url path http://localhost:3000/hotels will return all the hotels from API. (we saw that in postman)
                    //the http://localhost:3000/ is stored in our API_BASEURL variable 
                      //we need to add the hotels to the API_BASE_URL and send it to teh API server using callAPI object
                      //The API returns JSON formatted data which we need to convert to an Array of Hotel objects
                     //the RestTemplate class has a method called getForObject() that given a URL will do API GET request to the URL
                     // and return data in any Java data format we pick. 
                     //The format of getForObject() method: getForObject(String-with-URL, datatype-you-want-returned_

    
    return callAPI.getForObject(API_BASE_URL + "hotels", Hotel[].class); //Hotel[].class - array of Hotel class objects
    }
    public Review[] listReviews() {
        return callAPI.getForObject(API_BASE_URL + "reviews", Review[].class);
    }

    public Hotel getHotelById(int id) {
        return null;
    }

    public Review[] getReviewsByHotelId(int hotelID) {
        return null;
    }

    public Hotel[] getHotelsByStarRating(int stars) {
        return null;
    }

    public City getWithCustomQuery(){
        return null;
    }

}
