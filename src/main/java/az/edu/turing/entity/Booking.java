package az.edu.turing.entity;

import java.util.List;

public class Booking {
    private String id;
    private String passengerName;
    private Flight flight;
    private List<Passenger> passengers;

    public Booking(String passengerName, Flight flight, List<Passenger> passengers) {
        this.passengerName = passengerName;
        this.flight = flight;
        this.passengers = passengers;
        this.id = generateUniqueId();
    }

    private String generateUniqueId() {
        return "BKG" + System.currentTimeMillis();
    }

    public String getId() {
        return id;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public Flight getFlight() {
        return flight;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }
}