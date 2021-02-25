package com.techelevator.reservations.controllers;

//This will handle API calls sent to server with the paths specified in @RequestMapping
//API handler == Controllers 
//Typically controllers find data the caller needs to
//A controller normally does not have a lot of logic - its job is to get data and return it to the caller 
//Controllers are part of the MVC design pattern to structuring applications
//    MVC stands for Model-View-Controller - Model = data for application. View - how data is displayed to the user. Controller - Coordinates the data transfer between the Model and view
// in this application Model is handled by DAOs. View is handled by client. Controller is received request via API call from the client, find the data based on request and return it. 
import com.techelevator.reservations.dao.HotelDAO;
import com.techelevator.reservations.dao.MemoryHotelDAO;
import com.techelevator.reservations.dao.MemoryReservationDAO;
import com.techelevator.reservations.dao.ReservationDAO;
import com.techelevator.reservations.models.Hotel;
import com.techelevator.reservations.models.Reservation;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class HotelController {
  //Define references for each DAO we will use. 
	
	
	
    private HotelDAO hotelDAO;
    private ReservationDAO reservationDAO;

    
    //Constructor for this class of controllers 
    public HotelController() {
        this.hotelDAO = new MemoryHotelDAO(); //instatiate an ojbect with HotelDAO methods and assign to reference 
        this.reservationDAO = new MemoryReservationDAO(hotelDAO); //instantiate an object with ReservationDAO mehtods and assign to reference 
    }

    /**
     * Return All Hotels
     *
     * @return a list of all hotels in the system
     */ //requestmapping assigns a url path and ahttp request conbination to a method
    @RequestMapping(path = "/hotels", method = RequestMethod.GET) //this method will handle URLs sent to server with the /hotels path
    public List<Hotel> list() {
    	System.out.println("Called with the path /hotels");
        return hotelDAO.list();
    }

    /**
     * Return hotel information
     *
     * @param id the id of the hotel
     * @return all info for a given hotel
     */
    //this method will handle the path "/hotel/id" - "/hotels/1"
    @RequestMapping(path = "/hotels/{id}", method = RequestMethod.GET)
    public Hotel get(@PathVariable int id) {
        return hotelDAO.get(id);
    }
//write a controller thats going to return all the reservations when we get the path "/reservations"
    //we will use the ReservationsDAO find(All) method on the DAO to get the reservation
    @RequestMapping(path="/reservations", method=RequestMethod.GET) //if method= is missing it assumes GET
    public List<Reservation> anyNameYouWant() {
    	System.out.println("Called with the path /reservations");
    	return reservationDAO.findAll();
    }
    
    //write a controller to add a Reservation to the reservation resource on this server
   //using path: /hotels/id/reservations - id is the hotelId for the reservation
    //http://localhost:8080/hotels/1/reservations - should add a reservation for the hotel whose id is 1
    //the data for the new reservation will be in the body of the POST request used to call us. 
    //@RequestBody - create an object in the data in the body of the request. 
    //@PathVariable - gets the value from the data in the path. 
    @RequestMapping(path="hotels/{id}/reservations", method=RequestMethod.Post)
    public Reservation whatEverNameYouWaht(@RequestBody Reservation aReservation, @PathVariable("id")int hotelId) {
}
}
