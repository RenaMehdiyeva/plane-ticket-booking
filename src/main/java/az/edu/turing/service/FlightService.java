package az.edu.turing.service;

import az.edu.turing.entity.Flight;

import java.util.List;

public interface FlightService {
    List<Flight> getAvailableFlights();
    Flight getFlightDetails(String flightId);
    Flight getFlightById(String flightId);
}
