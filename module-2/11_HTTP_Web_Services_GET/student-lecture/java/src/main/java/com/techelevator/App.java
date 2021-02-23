package com.techelevator;

import com.techelevator.services.ConsoleService;
import com.techelevator.services.HotelService;

public class App {
     //Define a constaint to teh base/main part of the server URL, we are using 
    private static final String API_BASE_URL = "http://localhost:3000/";

    public static void main(String[] args) {
        int menuSelection = 999;
        int hotelId = -1;
   // instantiate object for the servicess we are using so we can access the methods in the service
        ConsoleService consoleService = new ConsoleService();  //handle all console interactions 
        HotelService hotelService = new HotelService(API_BASE_URL); //handle all hotel data resource interactions

        while (menuSelection != 0) {
            menuSelection = consoleService.printMainMenu(); //use the ConsoleService to display a menu and get response
            if (menuSelection == 1) {      // process based on the menu selection made by the user
               consoleService.printHotels(hotelService.listHotels());
            	
            	// System.out.println("Not implemented");//Call hotel services to get the hotel data in an array
                                                       //and then call the console service to print an array of hotels 
            } else if (menuSelection == 2) {
                System.out.println("Not implemented");
            } else if (menuSelection == 3) {
                System.out.println("Not implemented");
            } else if (menuSelection == 4) {
                System.out.println("Not implemented");
            } else if (menuSelection == 5) {
                System.out.println("Not implemented");
            } else if (menuSelection == 6) {
                System.out.println("Not implemented - Create a custom Web API query here");
            } else if (menuSelection == 0) {
                consoleService.exit();
            } else {
                // anything else is not valid
                System.out.println("Invalid Selection");
            }
            // Press any key to continue...
            if(hotelId != 0) {
                consoleService.next();
            }
            // Ensure loop continues
            menuSelection = 999;
        }

        // if the loop exits, so does the program
        consoleService.exit();
    }

}
