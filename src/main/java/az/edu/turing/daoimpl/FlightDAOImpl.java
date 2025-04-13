package az.edu.turing.daoimpl;

import az.edu.turing.dao.FlightDAO;
import az.edu.turing.entity.Flight;

import java.util.ArrayList;
import java.util.List;

public class FlightDAOImpl implements FlightDAO{
    private List<Flight> flights = new ArrayList<>();

    public FlightDAOImpl() {
        flights.add(new Flight("1", "Kiev", "Baku", "2025-04-14 10:00", 100));
        flights.add(new Flight("2", "Kiev", "London", "2025-04-14 15:00", 80));
        flights.add(new Flight("3", "Kiev", "Paris", "2025-04-14 20:00", 120));
    }

    @Override
    public List<Flight> getAllFlights() {
        return flights;
    }

    @Override
    public Flight getFlightById(String flightId) {
        for (Flight flight : flights) {
            if (flight.getId().equals(flightId)) {
                return flight;
            }
        }
        return null;
    }

    @Override
    public void saveFlights(List<Flight> flights) {
    }
}