package az.edu.turing.controller;

import az.edu.turing.entity.Flight;
import az.edu.turing.service.FlightService;


public class FlightController {
    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    public void displayAvailableFlights() {
        flightService.getAllFlights().forEach(flight -> {
            System.out.println("Flight ID: " + flight.getId() + " | Destination: " + flight.getDestination());
        });
    }

    public void showFlightDetails(String flightId) {
        Flight flight = flightService.getFlightById(flightId);
        if (flight != null) {
            System.out.println("Flight ID: " + flight.getId() + " | From: " + flight.getDeparture() + " | To: " + flight.getDestination());
        } else {
            System.out.println("Flight not found.");
        }
    }
}