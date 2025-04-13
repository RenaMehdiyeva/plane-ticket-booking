package az.edu.turing.controllerimpl;

import az.edu.turing.controller.BookingController;
import az.edu.turing.entity.Flight;
import az.edu.turing.entity.Booking;
import az.edu.turing.service.BookingService;
import az.edu.turing.service.FlightService;
import az.edu.turing.serviceimpl.BookingServiceImpl;
import az.edu.turing.serviceimpl.FlightServiceImpl;

import java.util.List;

public class BookingControllerImpl implements BookingController {
    private final BookingService bookingService;
    private final FlightService flightService;

    public BookingControllerImpl() {
        this.bookingService = new BookingServiceImpl();
        this.flightService = new FlightServiceImpl();
    }

    @Override
    public void searchAndBookFlight(String destination, String date, int numPassengers, String passengerName) {
        Flight flight = flightService.getAvailableFlights().stream()
                .filter(f -> f.getDestination().equals(destination) && f.getDateTime().toString().contains(date))
                .findFirst().orElse(null);

        if (flight != null) {
            Booking booking = bookingService.createBooking(flight.getId(), passengerName, numPassengers);
            System.out.println("Booking successful: " + booking);
        } else {
            System.out.println("No available flights for this destination and date.");
        }
    }

    @Override
    public void cancelBooking(String bookingId) {
        bookingService.cancelBooking(bookingId);
        System.out.println("Booking canceled successfully.");
    }

    @Override
    public void viewMyBookings(String passengerName) {
        List<Booking> bookings = bookingService.getBookingsByPassengerName(passengerName);

        if (bookings == null || bookings.isEmpty()) {
            System.out.println("No bookings found for passenger: " + passengerName);
        } else {
            System.out.println("Bookings for " + passengerName + ":");
            bookings.forEach(System.out::println);
        }
    }
}