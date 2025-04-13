package az.edu.turing.controller;

public interface BookingController {
    void searchAndBookFlight(String destination, String date, int numPassengers);
    void cancelBooking(String bookingId);
    void viewMyBookings(String passengerName);
}
