package az.edu.turing.service;

import az.edu.turing.entity.Flight;

import java.util.List;

public interface FlightService {
    List<Flight> getAvailableFlights();
    Flight getFlightDetails(String flightId);
    List<Flight> getFlightsByDestinationAndDate(String destination, String date, int numPassengers);
    Flight getFlightById(String flightId);
    boolean decreaseAvailableSeats(String flightId, int seats);
    List<Flight> getAllFlights();
}