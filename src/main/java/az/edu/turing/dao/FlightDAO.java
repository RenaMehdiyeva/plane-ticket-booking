package az.edu.turing.dao;

import az.edu.turing.entity.Flight;

import java.util.List;

public interface FlightDAO {
    List<Flight> getAllFlights();
    Flight getFlightById(String flightId);
    void saveFlights(List<Flight> flights);
    boolean updateFlight(Flight flight);
}