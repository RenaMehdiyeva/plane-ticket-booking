package az.edu.turing.serviceimpl;

import az.edu.turing.daoimpl.FlightDAOImpl;
import az.edu.turing.entity.Flight;
import az.edu.turing.service.FlightService;

import java.util.List;

public class FlightServiceImpl implements FlightService {
    private final FlightDAOImpl flightDao;

    public FlightServiceImpl() {
        this.flightDao = new FlightDAOImpl();
    }

    @Override
    public List<Flight> getAvailableFlights() {
        return flightDao.getAllFlights();
    }

    @Override
    public Flight getFlightDetails(String flightId) {
        return flightDao.getFlightById(flightId);
    }

    @Override
    public Flight getFlightById(String flightId) {
        return flightDao.getFlightById(flightId);
    }
}