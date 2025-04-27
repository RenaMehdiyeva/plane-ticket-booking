package az.edu.turing.daoimpl;

import az.edu.turing.dao.FlightDAO;
import az.edu.turing.entity.Flight;
import az.edu.turing.util.FileUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FlightDAOImpl implements FlightDAO{
    private static final String FLIGHTS_FILE = "flights.dat";
    private List<Flight> flights;

    public FlightDAOImpl() {
        this.flights = FileUtil.readFromFile(FLIGHTS_FILE);
        if (this.flights == null) {
            this.flights = new ArrayList<>();

            flights.add(new Flight("F100", "Kiev", "Baku", "2025-04-20 08:00", 150));
            flights.add(new Flight("F101", "Kiev", "Istanbul", "2025-04-20 10:30", 120));
            flights.add(new Flight("F102", "Kiev", "London", "2025-04-20 12:45", 180));
            FileUtil.writeToFile(FLIGHTS_FILE, flights);
        }
    }

    @Override
    public List<Flight> getAllFlights() {
        return new ArrayList<>(flights);
    }

    @Override
    public Flight getFlightById(String flightId) {
        return flights.stream()
                .filter(f -> f.getFlightId().equals(flightId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void saveFlights(List<Flight> flights) {
        this.flights = new ArrayList<>(flights);
        FileUtil.writeToFile(FLIGHTS_FILE, this.flights);
    }

    @Override
    public boolean updateFlight(Flight flight) {
        Optional<Flight> existingFlight = flights.stream()
                .filter(f -> f.getFlightId().equals(flight.getFlightId()))
                .findFirst();

        if (existingFlight.isPresent()) {
            int index = flights.indexOf(existingFlight.get());
            flights.set(index, flight);
            saveFlights(flights);
            return true;
        }
        return false;
    }
}