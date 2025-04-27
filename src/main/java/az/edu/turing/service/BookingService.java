package az.edu.turing.service;

import az.edu.turing.entity.Booking;
import az.edu.turing.entity.Passenger;

import java.util.List;

public interface BookingService {
    Booking createBooking(String flightId, String passengerName, List<Passenger> passengers);
    boolean cancelBooking(String bookingId);
    List<Booking> getBookingsByPassengerName(String passengerName);
}