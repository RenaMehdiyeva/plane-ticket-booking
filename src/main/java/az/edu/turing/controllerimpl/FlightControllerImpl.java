package az.edu.turing.controllerimpl;

import az.edu.turing.controller.FlightController;
import az.edu.turing.entity.Flight;
import az.edu.turing.service.FlightService;
import az.edu.turing.serviceimpl.FlightServiceImpl;

import java.util.List;

public class FlightControllerImpl implements FlightController {
    private final FlightService flightService;

    public FlightControllerImpl() {
        this.flightService = new FlightServiceImpl();
    }

    @Override
    public void displayAvailableFlights() {
        List<Flight> flights = flightService.getAvailableFlights();
        flights.forEach(System.out::println);
    }

    @Override
    public void showFlightDetails(String flightId) {
        Flight flight = flightService.getFlightDetails(flightId);
        if (flight != null) {
            System.out.println(flight);
        } else {
            System.out.println("Flight not found.");
        }
    }
}