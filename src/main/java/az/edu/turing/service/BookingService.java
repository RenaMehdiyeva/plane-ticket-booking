package az.edu.turing.service;

import az.edu.turing.entity.Booking;

import java.util.List;

public interface BookingService {
    Booking createBooking(String flightId, String passengerName, int numPassengers);
    void cancelBooking(String bookingId);
    List<Booking> getBookingsByPassengerName(String passengerName);
}
