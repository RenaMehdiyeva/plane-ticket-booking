package az.edu.turing.entity;

import java.util.List;

public class Booking {
    private final String bookingId;
    private final String passengerName;
    private final String flightId;
    private final List<Passenger> passengers;

    public Booking(String bookingId, String passengerName, String flightId, List<Passenger> passengers) {
        this.bookingId = bookingId;
        this.passengerName = passengerName;
        this.flightId = flightId;
        this.passengers = passengers;
    }

    public String getBookingId() {
        return bookingId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public String getFlightId() {
        return flightId;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public String toString() {
        return String.format("Reservation %s: %s | Flight ID: %s | Number of passengers: %d",
                bookingId, passengerName, flightId, passengers.size());
    }
}