package az.edu.turing.dao;

import az.edu.turing.entity.Booking;

import java.util.List;

public interface BookingDAO {
    List<Booking> getAllBookings();
    Booking getBookingById(String bookingId);
    void saveBookings(List<Booking> bookings);
}
