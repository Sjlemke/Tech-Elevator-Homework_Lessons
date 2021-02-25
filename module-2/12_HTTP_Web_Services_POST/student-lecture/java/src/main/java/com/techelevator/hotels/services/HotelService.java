package com.techelevator.hotels.services;

import com.techelevator.hotels.models.Hotel;
import com.techelevator.hotels.models.Reservation;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

public class HotelService {

  private final String BASE_URL;
  private final RestTemplate restTemplate = new RestTemplate();
  private final ConsoleService console = new ConsoleService();

  public HotelService(String url) {  //constructor for the HotelService that accepts the base URL
    BASE_URL = url;
  }

  /**
   * Create a new reservation in the hotel reservation system
   *
   * @param newReservation
   * @return Reservation
   */
  public Reservation addReservation(String newReservation) {
	  //To add a reservation to the API server we need a POST HTTP request
	  Reservation aReservation = makeReservation(newReservation);
	  //Now that we have a reservation object we need to use API to add it to the API resource
	  //We will use an HTTP Post request to do 
	  //An HTTP post required headers and the data to be added in the body of teh request 
	  HttpHeaders theHeaders = new httpHeaders();
	  theHeaders.setContentType(MediaType.APPLICATION_JSON); //define a header object to hold the header info for the
	                                                        //Set the content attribute of the headers to be APPLICATION_JSON
	                                                        //MediaType is a group of valid constants for request data type.
	  
	  HTTPEntity anEntity = new HttpEntity(aReservation, theHeaders); //Instantiate an HttpEntity object with the reservation object
	                                                                  //to be added to the API resource and the headers
	  
	  //Call the API with a Post request and the httpEntity we created 
	  aReservation = restTempplate.postForObject
	  
    return aReservation;
  }

  /**
   * Updates an existing reservation by replacing the old one with a new
   * reservation
   *
   * @param CSV - a comma delimited string with the new data
   * @return - http PUT does not return anything so neither are we! - return the reservation used to update
   */
  public Reservation updateReservation(String CSV) {
	  //to update we use a PUT Http request
	  Reservation aReservation = makeReservation(CSV); //use helper method to create a new reservstion to send to API server
  
	  //create the headers 
	  HttpHeaders theHeaders = new httpHeaders(); 
	  theHeaders.setContentType(MediaType.APPLICATION_JSON);
	  HttpEntity anEntity = new HttpEntity(aReservation, theHeaders);
	  
	  //call the API with an HTTP PUT to update the Reservation on the API resource
	  restTemplate.put(BASE_URL + "reservations", anEntity); //http put does not return anything
	  
	  return aReservation;
  }

  /**
   * Delete an existing reservation
   *
   * @param id
   */
  public void deleteReservation(int id) {
    // TODO: Implement method
  }

  /* DON'T MODIFY ANY METHODS BELOW */

  /**
   * List all hotels in the system
   *
   * @return
   */
  public Hotel[] listHotels() {
    Hotel[] hotels = null;
    try {
      hotels = restTemplate.getForObject(BASE_URL + "hotels", Hotel[].class);
    } catch (RestClientResponseException ex) {
      // handles exceptions thrown by rest template and contains status codes
      console.printError(ex.getRawStatusCode() + " : " + ex.getStatusText());
    } catch (ResourceAccessException ex) {
      // i/o error, ex: the server isn't running
      console.printError(ex.getMessage());
    }
    return hotels;
  }

  /**
   * Get the details for a single hotel by id
   *
   * @param id
   * @return Hotel
   */
  public Hotel getHotel(int id) {
    Hotel hotel = null;
    try {
      hotel = restTemplate.getForObject(BASE_URL + "hotels/" + id, Hotel.class);
    } catch (RestClientResponseException ex) {
      console.printError(ex.getRawStatusCode() + " : " + ex.getStatusText());
    } catch (ResourceAccessException ex) {
      console.printError(ex.getMessage());
    }
    return hotel;
  }

  /**
   * List all reservations in the hotel reservation system
   *
   * @return Reservation[]
   */
  public Reservation[] listReservations() {
    Reservation[] reservations = null;
    try {
      reservations = restTemplate.getForObject(BASE_URL + "reservations", Reservation[].class);
    } catch (RestClientResponseException ex) {
      console.printError(ex.getRawStatusCode() + " : " + ex.getStatusText());
    } catch (ResourceAccessException ex) {
      console.printError(ex.getMessage());
    }
    return reservations;
  }

  /**
   * List all reservations by hotel id.
   *
   * @param hotelId
   * @return Reservation[]
   */
  public Reservation[] listReservationsByHotel(int hotelId) {
    Reservation[] reservations = null;
    try {
      reservations = restTemplate.getForObject(BASE_URL + "hotels/" + hotelId + "/reservations", Reservation[].class);
    } catch (RestClientResponseException ex) {
      console.printError(ex.getRawStatusCode() + " : " + ex.getStatusText());
    } catch (ResourceAccessException ex) {
      console.printError(ex.getMessage());
    }
    return reservations;
  }

  /**
   * Find a single reservation by the reservationId
   *
   * @param reservationId
   * @return Reservation
   */
  public Reservation getReservation(int reservationId) {
    Reservation reservation = null;
    try {
      reservation = restTemplate.getForObject(BASE_URL + "reservations/" + reservationId, Reservation.class);
    } catch (RestClientResponseException ex) {
      console.printError(ex.getRawStatusCode() + " : " + ex.getStatusText());
    } catch (ResourceAccessException ex) {
      console.printError(ex.getMessage());
    }
    return reservation;
  }

  private Reservation makeReservation(String CSV) {
    String[] parsed = CSV.split(",");

    // invalid input (
    if (parsed.length < 5 || parsed.length > 6) {
      return null;
    }

    // Add method does not include an id and only has 5 strings
    if (parsed.length == 5) {
      // Create a string version of the id and place into an array to be concatenated
      String[] withId = new String[6];
      String[] idArray = new String[] { new Random().nextInt(1000) + "" };
      // place the id into the first position of the data array
      System.arraycopy(idArray, 0, withId, 0, 1);
      System.arraycopy(parsed, 0, withId, 1, 5);
      parsed = withId;
    }

    return new Reservation(Integer.parseInt(parsed[0].trim()), Integer.parseInt(parsed[1].trim()), parsed[2].trim(),
        parsed[3].trim(), parsed[4].trim(), Integer.parseInt(parsed[5].trim()));
  }

}
