package az.edu.turing.serviceimpl;

import az.edu.turing.dao.BookingDAO;
import az.edu.turing.daoimpl.BookingDAOImpl;
import az.edu.turing.entity.Booking;
import az.edu.turing.entity.Flight;
import az.edu.turing.entity.Passenger;
import az.edu.turing.service.BookingService;
import az.edu.turing.service.FlightService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookingServiceImpl implements BookingService {
    private final BookingDAO bookingDAO;
    private final FlightService flightService;

    public BookingServiceImpl() {
        this.bookingDAO = new BookingDAOImpl();
        this.flightService = new FlightServiceImpl();
    }

    @Override
    public Booking createBooking(String flightId, String passengerName, int numPassengers) {
        Flight flight = flightService.getFlightById(flightId);
        List<Passenger> passengers = new ArrayList<>();

        for (int i = 0; i < numPassengers; i++) {
            passengers.add(new Passenger("Passenger " + (i + 1)));
        }

        return new Booking(passengerName, flight, passengers);
    }

    @Override
    public void cancelBooking(String bookingId) {
    }

    @Override
    public List<Booking> getBookingsByPassengerName(String passengerName) {
        List<Booking> allBookings = bookingDAO.getAllBookings();
        return allBookings.stream()
                .filter(booking -> booking.getPassengerName().equals(passengerName))
                .collect(Collectors.toList());
    }
}