package az.edu.turing.controller;

import az.edu.turing.entity.Booking;
import az.edu.turing.entity.Passenger;
import az.edu.turing.service.BookingService;

import java.util.List;

public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    public Booking bookFlight(String flightId, String passengerName, List<Passenger> passengers) {
        return bookingService.createBooking(flightId, passengerName, passengers);
    }

    public boolean cancelBooking(String bookingId) {
        return bookingService.cancelBooking(bookingId);
    }

    public List<Booking> viewBookings(String passengerName) {
        return bookingService.getBookingsByPassengerName(passengerName);
    }
}