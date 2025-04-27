package az.edu.turing.serviceimpl;

import az.edu.turing.dao.FlightDAO;
import az.edu.turing.entity.Flight;
import az.edu.turing.service.FlightService;

import java.util.List;
import java.util.stream.Collectors;

public class FlightServiceImpl implements FlightService {
    private final FlightDAO flightDao;

    public FlightServiceImpl(FlightDAO flightDao) {
        this.flightDao = flightDao;
    }

    @Override
    public List<Flight> getAllFlights() {
        return flightDao.getAllFlights();
    }

    @Override
    public List<Flight> getAvailableFlights() {
        return flightDao.getAllFlights().stream()
                .filter(f -> f.getAvailableSeats() > 0)
                .collect(Collectors.toList());
    }

    @Override
    public Flight getFlightDetails(String flightId) {
        return flightDao.getFlightById(flightId);
    }

    @Override
    public List<Flight> getFlightsByDestinationAndDate(String destination, String date, int numPassengers) {
        return flightDao.getAllFlights().stream()
                .filter(f -> f.getDestination().equalsIgnoreCase(destination) &&
                        f.getDate().equals(date) &&
                        f.getAvailableSeats() >= numPassengers)
                .collect(Collectors.toList());
    }

    @Override
    public Flight getFlightById(String flightId) {
        return flightDao.getFlightById(flightId);
    }

    @Override
    public boolean decreaseAvailableSeats(String flightId, int seats) {
        Flight flight = flightDao.getFlightById(flightId);
        if (flight != null && flight.getAvailableSeats() >= seats) {
            flight.setAvailableSeats(flight.getAvailableSeats() - seats);
            return flightDao.updateFlight(flight);
        }
        return false;
    }
}